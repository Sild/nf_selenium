package neverfate_bot;

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
        boolean can_move;
        int step = 0;
        for (Integer node : this.map) {
            System.out.println("step " + ++step);
            can_move = false;
            int timer = 0;
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
            try {
                selen.click(Field.Move.pack_of_wolves);
                System.out.println("pack finded");
                Fight.begin();
             } catch ( Exception nopack) {

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
}
