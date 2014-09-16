
public class Nfconfig {
	private Nfconfig() {
		System.out.println("initialize config");
	}
	private static Nfconfig instance;
	
	public static Nfconfig getInstance() {
		if(null == Nfconfig.instance) {
			Nfconfig.instance = new Nfconfig();
		}
		return Nfconfig.instance;
	}
	
	public final String mail = "fakemail@mail.com";
	public final String birthday = "19.09.1984";
	public final String login_postfix = "_inc";
}
