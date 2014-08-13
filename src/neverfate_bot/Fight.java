package neverfate_bot;


public class Fight {
	public static void begin() {//USE AFTER FIGHT START
		System.out.println("fight begin!");
		
		Selenium selen = Selenium.getInstance();
		selen.switch_to();
		selen.switch_to(Field.Panel.iframe_main);
		try {
			
			try {
				selen.click(Field.Fight.set_magic);//.two_hit);
				selen.switch_to();
				selen.click(Field.Fight.set_target);
				selen.switch_to(Field.Panel.iframe_main);
				selen.click(Field.Fight.make_step);
			}catch(Exception no_mage) {
				selen.click(Field.Fight.two_hit);
			}
			Fight.begin();
		}catch (Exception e) {
			exit(selen);
		}
		System.out.println("fight end!");
	}
	
	private static void exit(Selenium selen) {
		try {
			selen.find(Field.Fight.personal);
		}catch (Exception f) {
			try {
                Thread.sleep(500);
				selen.click(Field.Fight.refresh);
				Fight.exit(selen);//EXIT ONLY WITH EXCEPTION ON FIND REFRESH
			} catch (Exception ol) {
			}
		}
		
	}
}
