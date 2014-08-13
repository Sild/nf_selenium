package neverfate_bot;

/**
 * Created by sild on 6/25/14.
 */
public class Chrine {
    public static void start_pray() {
    	
        Selenium selen = Selenium.getInstance();
        selen.switch_to(Field.Panel.iframe_main);
        while(true) {
        	try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e1) {
    		}
            try {
                selen.click(Field.Shrine.prayer);
            }catch (Exception allready_pray) {
                try {
                    selen.click(Field.Shrine.chapel);
                } catch (Exception e) {

                }

            }
            
            try {
                selen.click(Field.Shrine.prayer);
            }catch (Exception allready_pray) {
                try {
                    selen.click(Field.Shrine.chapel2);
                } catch (Exception e) {

                }

            }
        }


    }
}
