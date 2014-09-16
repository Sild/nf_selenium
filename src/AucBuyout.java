
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AucBuyout {
	static String site = "http://neverfate.ru";
	static String reg_button = "/html/body/div[2]/div[1]/div[5]";
	static String login_field = "//*[@id=\"regFF\"]/table[1]/tbody/tr[1]/td[2]/input";
	static String mail_field = "//*[@id=\"regFF\"]/table[1]/tbody/tr[2]/td[2]/input";
	static String birthday_field = "//*[@id=\"regFF\"]/table[1]/tbody/tr[3]/td[2]/input";
	static String enter_in_game_button = "//*[@id=\"regFF\"]/table[2]/tbody/tr/td/table/tbody/tr/td/div/div[2]";
	static String enter_in_game_button2 = "//*[@id=\"content_body_id\"]/table/tbody/tr/td/table/tbody/tr/td/div[2]/table/tbody/tr/td/div/div[2]";
	static String IFRAME_TOP = "//*[@id=\"ch_navigate\"]";
	static String IFRAME_MAIN = "//*[@id=\"fh\"]/tbody/tr[2]/td/iframe";
	static String STREET_BUTTON = "//div[@class=\"top_nav_12\"]";
	static String ctr_button = "/html/body/table[2]/tbody/tr/td[2]/div[1]/img[7]";
	static String auc_button = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td/div[3]/div[2]";
	static String good_field = "//*[@id=\"sname_id\"]";
	static String use_filter = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr/td/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td/div[2]/div[2]";
	static String go_goods = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/div/table/tbody/tr[3]/td/form/div/div/div[2]";
	static WebDriver driver;
	static String last_page = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/div/table/tbody/tr[3]/td/a[4]";
	static String buy_button = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/div/table/tbody/tr[5]/td/div[2]/div/div[2]";
	static String confim = "//*[@id=\"TrashWindowContent_id\"]/table/tbody/tr/td/div[1]/div[2]";
	static String exit_button = "/html/body/div/table/tbody/tr/td[3]/div[12]";
	static Integer count = 2;
	static String drova = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[1]/div/table/tbody/tr/td[1]/div/div/a[43]";
	static Integer another_count = 2;
	public static void start() {
		
		driver = new ChromeDriver();
		

		while(true) {
			try {
				make();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void make() {
		driver.get(site);
		String login = "";
		login = "dqp_" + another_count.toString() + "chat" + count.toString();
		count++;
		another_count++;
		try {
			registration("variora1996");
		} catch (Exception e) {
			System.out.println("sleep exception");
		}
		
		go_to_chtr();
		set_filter();
		buy();
		exit();
	}
	
	public static void exit() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_TOP)));
		driver.findElement(By.xpath(exit_button)).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(confim)).click();
	}
	public static void buy() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_MAIN)));
		driver.findElement(By.xpath(last_page)).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_MAIN)));
		driver.findElement(By.xpath(buy_button)).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(confim)).click();
	}
	public static void set_filter() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_MAIN)));
		driver.findElement(By.xpath(good_field)).sendKeys("хворост");
		driver.findElement(By.xpath(use_filter)).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_MAIN)));
		driver.findElement(By.xpath(go_goods)).click();
	}
	
	public static void go_to_chtr() {
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_TOP)));
		driver.findElement(By.xpath(STREET_BUTTON)).click();
		driver.switchTo().defaultContent();
//		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_MAIN)));
//		driver.findElement(By.xpath(ctr_button)).click();
	}
	
	
	public static void registration(String login) throws InterruptedException {
		driver.findElement(By.xpath(reg_button)).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(login_field)).sendKeys(login);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(mail_field)).sendKeys("mailmail@mail.mail");
		Thread.sleep(1000);
		driver.findElement(By.xpath(birthday_field)).sendKeys("17.06.1995");
		Thread.sleep(1000);		
		Boolean screenChange = false;
		Integer timer = 0;
		while(!screenChange) {
			try {
				driver.findElement(By.xpath(enter_in_game_button)).click();	
				Thread.sleep(5000);
				timer += 2;
				if(timer >= 130) {
					count++;
					another_count++;
					make();
				}
			} catch (Exception e) {
				driver.findElement(By.xpath(enter_in_game_button2)).click();
				screenChange = true;
			}
		}
		
	}
	
	

}
