package neverfate_bot;

public class Field {
	public static Field getInstance() {
		if(null == Field.instance) {
			instance = new Field();
		}
		return Field.instance;
	}
	
	private static Field instance = null;
	
	private Field() {
		System.out.println("sign browser fields...");
	}
	
	final public class Nogame {
		public static final String login = "//*[@id=\"logfrm\"]/input[1]";
		public static final String password = "//*[@id=\"pass_input_id\"]";
		public static final String enter = "/html/body/div[2]/div[1]/div[3]";
		public static final String reg_button = "/html/body/div[2]/div[1]/div[5]";
		public static final String reg_login = "//*[@id=\"regFF\"]/table[1]/tbody/tr[1]/td[2]/input";
		public static final String reg_mail = "//*[@id=\"regFF\"]/table[1]/tbody/tr[2]/td[2]/input";
		public static final String birthday = "//*[@id=\"regFF\"]/table[1]/tbody/tr[3]/td[2]/input";
		public static final String enter_in_game_button = "//*[@id=\"regFF\"]/table[2]/tbody/tr/td/table/tbody/tr/td/div/div[2]";
		public static final String enter_in_game_button2 = "//*[@id=\"content_body_id\"]/table/tbody/tr/td/table/tbody/tr/td/div[2]/table/tbody/tr/td/div/div[2]";
	}
	
	final public class Move {
		public static final String catacomb = "/html/body/table[2]/tbody/tr/td[3]/span";
        public static final String pack_of_wolves = "/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[2]/span[3]";
		public static final String chtr_button = "/html/body/table[2]/tbody/tr/td[2]/div[1]/img[7]";
		public static final String battle_hall = "/html/body/table[2]/tbody/tr/td[2]/div[1]/img[5]";
		public static final String area_eternity = "/html/body/table[2]/tbody/tr/td[2]/div/img[8]";
		public static final String secret_hall = "/html/body/table[2]/tbody/tr/td[2]/div/img[10]";
		public static final String enter_catacomb = "/html/body/table[2]/tbody/tr/td[3]/span";
		public static final String can_move = "//*[@id=\"go_timer_progress\"]/img[10]";// "//*[@id=\"moveid\"]/font[@color=\"green\"]/b";
        public static final String admin_hall = "/html/body/table[2]/tbody/tr/td[2]/div[1]/img[7]";
        public static final String holiday = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td/div[1]/div[2]";
        public static final String exit_holiday = "/html/body/table/tbody/tr[2]/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/div[2]/div[2]";
		
	}
	
	final public class Fight {
		public static final String set_magic = "/html/body/table/tbody/tr/td[2]/form/table[1]/tbody/tr/td/img";
		public static final String set_target = "//*[@id=\"bslform\"]/div[3]/div[2]";
		public static final String two_hit = "/html/body/table/tbody/tr/td[2]/form/table[1]/tbody/tr/td/div[2]/div[2]";
		public static final String make_step = "/html/body/table/tbody/tr/td[2]/form/table[2]/tbody/tr[2]/td/table/tbody/tr/td/div/div[2]";
		public static final String refresh = "/html/body/table/tbody/tr/td[2]/table[1]/tbody/tr/td/div/div[2]";
		public static final String personal = "/html/body/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div[1]/table/tbody/tr/td[1]/div/div/table/tbody/tr[1]/td[1]";
	}

    final public class Shrine {
        public static final String chapel = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td/div[1]/div[2]";
        public static final String prayer = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/div/form/div[2]/div[2]";
        public static final String chapel2 = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td/div[2]/div[2]";
    }
	
	final public class Panel {
		public static final String iframe_top = "//*[@id=\"ch_navigate\"]";
		public static final String iframe_main = "//*[@id=\"fh\"]/tbody/tr[2]/td/iframe";
		public static final String go_street = "//div[@class=\"top_nav_12\"]";
		public static final String war = "//div[@class=\"top_nav_10\"]";
        public static final String exit = "/html/body/div/table/tbody/tr/td[3]/div[12]";
        public static final String rooms = "/html/body/div/table/tbody/tr/td[3]/div[2]";
	}
	
	final public class Action {
		public static final String start_war_bot = "//*[@id=\"oform\"]/span";
	}
	
	final public class Catacomb {
		public static final String north = "//*[@id=\"navtbl\"]/table/tbody/tr[1]/td/table/tbody/tr/td/div/div[2]";
		public static final String south = "//*[@id=\"navtbl\"]/table/tbody/tr[3]/td/table/tbody/tr/td/div/div[2]";
		public static final String west = "//*[@id=\"navtbl\"]/table/tbody/tr[2]/td[2]/table/tbody/tr/td/div/div[2]";
		public static final String east = "//*[@id=\"navtbl\"]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div/div[2]";
		public static final String exit = "/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[3]/span[3]";
		public static final String image = "/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[1]/td/div/img[2]";
		
	}
	
	
	
	

	

	
	 public final String pers = "/html/body/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div[1]/table/tbody/tr/td[1]/div/div/table/tbody/tr[1]/td[1]";
}
