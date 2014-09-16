
/**
 * Created by sild on 6/25/14.
 */
public class Chrine {
    public static void start_pray() {
    	
        Selenium selen = Selenium.getInstance();
        selen.switch_to(Field.Panel.iframe_main);
        while(true) {
            selen.click(Field.Shrine.chapel);
            selen.click(Field.Shrine.prayer);
            try
            {
                Thread.sleep(10000);
            }catch(Exception e)
            {
                System.out.println("sleep exception");
            }
        }


    }
}
