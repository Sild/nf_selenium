
public class Nogame {
	
	public static void auth(String login, String password) {
        if(Selenium.getInstance().getCurrentUser() != login) {
//            Selenium.getInstance().exit();
            Selenium.getInstance().click(Field.Nogame.login);
            Selenium.getInstance().send(Field.Nogame.login, login);
            Selenium.getInstance().click(Field.Nogame.password);
            Selenium.getInstance().send(Field.Nogame.password, password);
            Selenium.getInstance().click(Field.Nogame.enter);
        }

	}
	
	public static void registration(String login) {
		Selenium selen = Selenium.getInstance();
		Nfconfig conf = Nfconfig.getInstance();
		selen.click(Field.Nogame.reg_button);

		selen.send(Field.Nogame.reg_login, login);
		selen.send(Field.Nogame.reg_mail, conf.mail);
		selen.send(Field.Nogame.birthday, conf.birthday);
		
		Boolean screenChange = false;
		Integer timer = 0;
		while(!screenChange) {
			try {
				selen.click(Field.Nogame.enter_in_game_button);
				Thread.sleep(2000);
				timer += 2;
				if(timer >= 130) {
					registration(login + conf.login_postfix);
				}
			} catch (Exception e) {
				selen.click(Field.Nogame.enter_in_game_button2);
				screenChange = true;
			}
		}
		
	}
	
}
