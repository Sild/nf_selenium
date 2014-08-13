package neverfate_bot;

import java.util.Vector;

public class Catacomb {
	private Vector<Maps.Catacomb_node> map;
	public Catacomb() {
		this.map = Maps.get_catacomb_map();
	}
	
	public void run() {
		Selenium selen = Selenium.getInstance();
		
		try {
			selen.switch_to(Field.Panel.iframe_top);
			selen.click(Field.Panel.rooms);
			selen.switch_to();
			selen.switch_to(Field.Panel.iframe_main);
			selen.click(Field.Move.catacomb);
		}catch (Exception e) {
			
		}
		selen.switch_to();
		selen.switch_to(Field.Panel.iframe_main);
		boolean can_move;
		int step = 0;
		for (Maps.Catacomb_node node : this.map) {
			System.out.println("step " + ++step);
			can_move = false;
			while(!can_move) {
				try {
					selen.find(Field.Move.can_move);
					can_move = true;
					
				}catch (Exception e) {
                   try {
                       selen.click(Field.Fight.refresh);
                   } catch (Exception fight_finsh) {

                   }
				}
			}
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

					
			switch ( node.action ) {
			case 0:
				break;
				
			case 1:
				try {
					selen.click(Field.Catacomb.image);
					Fight.begin();
					selen.click(Field.Catacomb.image);
				} catch (Exception e) {
					System.out.println("no corpse or mob allready killed");
				}
				
				break;
			case 2://in case 2-4 make same action - press on image
			case 3:
			case 4:
				try {
					selen.click(Field.Catacomb.image);
				} catch (Exception nokey) {
					System.out.println("key allready taken?");
				}
				
				break;
			default:
				break;
					
			
			}
		}
		
		try {
			Thread.sleep(1440000);
		}catch(Exception e) {
			
		}
		this.run();
	}
	
	

}