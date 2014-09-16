

public class Lvlup {
	
	public static void start() {

		while(true) {
			Selenium.getInstance().switch_to();
			Selenium.getInstance().switch_to(Field.Panel.iframe_top);
			Selenium.getInstance().click(Field.Panel.war);
			start_fight();
			Fight.begin();
		}
		
			
	}
	
	
	private static void start_fight() {
		Boolean fight_started = false;
		Selenium.getInstance().switch_to();
		Selenium.getInstance().switch_to(Field.Panel.iframe_main);
		while(Selenium.getInstance().find(Field.Action.start_war_bot)) {
			Selenium.getInstance().click(Field.Action.start_war_bot);
			try {
				Thread.sleep(10000);
			}catch (Exception e) {
				
			}
		}
	}
	

}
