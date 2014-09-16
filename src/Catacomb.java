
import java.util.Vector;

public class Catacomb {
	private Vector<Maps.Catacomb_node> map;
	public Catacomb() {
		this.map = Maps.get_catacomb_map();
	}
	
	public void run() {
		Selenium selen = Selenium.getInstance();
        enter_cata(selen);
		full_cata(selen);
	}
    private void enter_cata(Selenium selen)
    {
        selen.switch_to();
        selen.switch_to(Field.Panel.iframe_top);
        selen.click(Field.Panel.go_street);
    }
	private void full_cata(Selenium selen) {
		selen.switch_to();
		selen.switch_to(Field.Panel.iframe_main);
		while(selen.find(Field.Move.catacomb)) {
			selen.click(Field.Move.catacomb);
			try {
				Thread.sleep(10000);
			}catch(Exception e) {		
			}
			
		}
		int step = 0;
		for (Maps.Catacomb_node node : this.map) {
			this.wait_allow_move(selen);
			switch( node.direct ) {
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
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}

					
			switch ( node.action ) {
			case 0:
				break;
				
			case 1:
				selen.click(Field.Catacomb.image);
				Fight.begin();
				selen.click(Field.Catacomb.image);
				break;
			case 2://in case 2-4 make same action - press on image
			case 3:
			case 4:
				selen.click(Field.Catacomb.image);
				break;
			default:
				break;
					
			
			}
		}

		
		this.full_cata(selen);
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
