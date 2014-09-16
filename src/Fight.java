package neverfate_bot;


public class Fight {
	public static void begin() {//USE AFTER FIGHT START
		
		Selenium selen = Selenium.getInstance();
		selen.switch_to();
		selen.switch_to(Field.Panel.iframe_main);
		if(selen.find(Field.Fight.set_magic)) {
			while(selen.find(Field.Fight.set_magic)) {
				selen.click(Field.Fight.set_magic);//. two_hit);
				selen.switch_to();
				selen.click(Field.Fight.set_target);
				selen.switch_to(Field.Panel.iframe_main);
				selen.click(Field.Fight.make_step);
			}
		} else if( selen.find(Field.Fight.two_hit) ) {
			while(selen.find(Field.Fight.two_hit)) {
				selen.click(Field.Fight.two_hit);
			}
			
		} else {
			exit(selen);
		}
	}
	
	private static void exit(Selenium selen) {
		while(selen.find(Field.Fight.refresh)) {
			selen.click(Field.Fight.refresh);
			try {
				 Thread.sleep(500);
			} catch (Exception ol) {
					
			}
		}
		
       
        
				
	}
}
