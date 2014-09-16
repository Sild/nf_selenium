
import java.util.Vector;

/**
 * Created by sild on 6/22/14.
 */
public class PackOfWolves {
    private Vector<Integer> map;
    public PackOfWolves() {
        this.map = Maps.get_drem_map();
    }

    public void run() {
        Selenium selen = Selenium.getInstance();
        selen.switch_to();
        selen.switch_to(Field.Panel.iframe_main);
        int step = 0;
        for (Integer node : this.map) {
            System.out.println("step " + ++step);
            wait_allow_move(selen);
            if(selen.find(Field.Move.pack_of_wolves)) {
            	selen.click(Field.Move.pack_of_wolves);
                System.out.println("pack finded");
                Fight.begin();
            }
            switch( node ) {
                case 0:
                    selen.click(Field.Catacomb.north);
                    break;
                case 1:
                    selen.click(Field.Catacomb.east);
                    break;
                case 2:
                    selen.click(Field.Catacomb.south);
                    break;
                case 3:
                    selen.click(Field.Catacomb.west);
                    break;
                default:
                    break;
            }

            Fight.begin();
        }
    }
    
    private void wait_allow_move(Selenium selen) {
		while(!selen.find(Field.Move.can_move)) {
			selen.click(Field.Fight.refresh);
	        selen.switch_to();
	        selen.switch_to(Field.Panel.iframe_top);
	        selen.click(Field.Panel.go_street);
	        selen.switch_to();
	        selen.switch_to(Field.Panel.iframe_main);
	        try {
	        	Thread.sleep(500);
	        } catch (Exception e) {
	        	
	        }
		}
		
	}
}
