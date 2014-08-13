package neverfate_bot;


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
		do {
			try {
				Selenium.getInstance().switch_to();
				Selenium.getInstance().switch_to(Field.Panel.iframe_main);
				Selenium.getInstance().click(Field.Action.start_war_bot);
				Thread.sleep(10000);
			}catch (Exception e) {
				fight_started = true;
			}
		}while(!fight_started);
	}
	

}