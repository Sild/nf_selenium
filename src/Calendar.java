package neverfate_bot;

import java.util.Map;
import java.util.Vector;

/**
 * Created by sild on 6/19/14.
 */
public class Calendar {
    public static void check(Map<String, UserManager.User> users) {
        for(Map.Entry<String, UserManager.User> user : users.entrySet()) {
            Nogame.auth(user.getKey(), user.getValue().password());
            Selenium selen = Selenium.getInstance();
            selen.switch_to(Field.Panel.iframe_top);
            selen.click(Field.Panel.go_street);
            selen.switch_to();
            selen.switch_to(Field.Panel.iframe_main);
            selen.click(Field.Move.admin_hall);
            selen.click(Field.Move.holiday);

            //place to click check_holiday

            selen.click(Field.Move.exit_holiday);
            selen.switch_to();
            selen.switch_to(Field.Panel.iframe_top);
            selen.click(Field.Panel.go_street);
            selen.switch_to();
            selen.switch_to(Field.Panel.iframe_main);
            selen.click(Field.Move.battle_hall);
            selen.exit();
        }
    }
}
