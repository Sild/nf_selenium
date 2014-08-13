package neverfate_bot;
import java.util.Map;
import java.util.Vector;
/**
 * Created by sild on 6/20/14.
 */
public class UserManager {

    public static UserManager getInstance() {
        UserManager localInstance = instance;
        if (null == localInstance) {
            synchronized (UserManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new UserManager("./data/users");
                }
            }
        }
        return localInstance;
    }

    public Map<String, User> users() {
        return this.users;
    }
    
    private static volatile UserManager instance = null;

    private UserManager(String usersFilePath) {
        String[] splited;
        this.users = new java.util.HashMap<String, User>();


        Vector<String> usersData = Data.read_data(usersFilePath);
        for(String userData : usersData) {
            splited = userData.split(" ");
            this.users.put(splited[0], new User(splited[0], splited[1]));
        }
    }

    private Map<String, User> users;

    public class User {
        public String login() { return this.login; }
        public String password(){ return this.password; }
        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        private String login;
        private String password;
    }





}
