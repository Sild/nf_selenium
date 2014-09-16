
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {
	private String currentUser;
    public String getCurrentUser() {
        return this.currentUser;
    }
    public void setCurrentUser(String user) {
        this.currentUser = user;
    }
	public static Selenium getInstance() {
		if(null == Selenium.instance) {
			Selenium.instance = new Selenium("http://neverfate.ru");
		}
		return Selenium.instance;
	}
	
	private static Selenium instance = null;
	private WebDriver driver;
	
	private Selenium(String url) {
		this.driver = new FirefoxDriver();
		this.driver.get(url);
	}
	
	public void click(String xpath) {
		if(this.find(xpath)) {
			this.driver.findElement(By.xpath(xpath)).click();
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				
			}
		}
	}
	
	public void send(String xpath, String text) {
		if(this.find(xpath)) {
			this.driver.findElement(By.xpath(xpath)).clear();
			this.driver.findElement(By.xpath(xpath)).sendKeys(text);
		}
        
	}
	
	public void switch_to(String xpath) {
		if(this.find(xpath)) {
			driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
		}
		
	}
	
	public void switch_to() {
		driver.switchTo().defaultContent();
	}
	
	public boolean find(String xpath) {
		try {
			this.driver.findElement(By.xpath(xpath));
			if(this.driver.findElement(By.xpath(xpath)).isDisplayed()) {
				return true;
			} else {
				return false;
			}
			
		}catch(Exception e) {
//			System.out.println("element with xpath: " + xpath + " not found");
			return false;
		}
        
	}

    public void exit() {
        this.switch_to(Field.Panel.iframe_top);
        this.click(Field.Panel.exit);
        this.currentUser = null;
        Selenium.instance = null;
    }

    public void close() {
        this.driver.close();
    }
}
