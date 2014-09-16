package neverfate_bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import neverfate_bot.UserManager.User;

public class Main {

	public static void main(String[] args) {
//		AucBuyout.start();

		String login = null;
		String action = null;
		if(args.length == 2 && args[1] == "gui") {
	        new Gui();			
		} else if (args.length == 3) {
			login = args[1];
			action = args[2];
		}
		
		while(login == null) {
			login = select_login();
		}
		System.out.println("selected login: " + login);
		
		
		while(action == null) {
			action = select_action();
		}
		System.out.println("selected action: " + action);
		
		handle(login, action);
		
		

	}
	
	private static void handle(String login, String action) {
		if( "lvlup" == action) {
            String password = UserManager.getInstance().users().get(login).password();
            Nogame.auth(login, password);
            Lvlup.start();
        } else if ("catacomb" == action) {
            String password = UserManager.getInstance().users().get(login).password();
            Nogame.auth(login, password);
            new Catacomb().run();
        }else if ("pack_of_wolves" == action) {
            String password = UserManager.getInstance().users().get(login).password();
            Nogame.auth(login, password);
            while(true) {
                new PackOfWolves().run();
            }

        } else if ("calendar" == action) {
            Calendar.check(UserManager.getInstance().users());

        } else if ( "pray" == action) {
            String password = UserManager.getInstance().users().get(login).password();
            Nogame.auth(login, password);
            Chrine.start_pray();

        }
	}
	
	
	private static String select_action() {
		String result = null;
		System.out.print("available action: ");
		Vector<String> actions = new Vector<String>(Arrays.asList("lvlup", "catacomb", "pack_of_wolves", "calendar", "pray"));
		for(int i = 0; i < actions.size(); i++) {
			System.out.print("[" + i + "]" + actions.get(i) +"; ");
		}
	    System.out.println();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String input = null;
	    try {
	    	input = reader.readLine();
	    }catch (IOException e) {
            e.printStackTrace();
        } 
	    int number;
	    try {
	    	number = Integer.parseInt(input);
	    } catch (Exception e) {
	    	ExceptionHandler.stringToInteger(input);
	    	return null;
	    }
	    if(number >= actions.size() || number < 0) {
	    	System.out.println("input number `" + number + "` is too big");
	    	result = null;
	    } else {
	    	result = actions.get(number);
	    }
	    return result;
		
	}
	@SuppressWarnings("rawtypes")
	private static String select_login() {
		String result = null;
		System.out.print("available login: ");
		Map<String, User> users = UserManager.getInstance().users();
		Iterator it = users.entrySet().iterator();
		int i = 0;
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        System.out.print("[" + i++ + "]" + pairs.getKey() + "; ");
	    }
	    System.out.println();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String input = null;
	    try {
	    	input = reader.readLine();
	    }catch (IOException e) {
            e.printStackTrace();
        } 
	    int number;
	    try {
	    	number = Integer.parseInt(input);
	    } catch (Exception e) {
	    	ExceptionHandler.stringToInteger(input);
	    	return null;
	    }
	    if(number >= i || number < 0) {
	    	System.out.println("input number `" + number + "` is too big");
	    	result = null;
	    } else {
	    	i = 0;
	    	it = users.entrySet().iterator();
		    while (i < users.size()) {
		        Map.Entry pairs = (Map.Entry)it.next();
		        if(number == i++) {
		        	result = (String) pairs.getKey();
		        	break;
		        }
		    }
	    }
	    return result;
	}
}
