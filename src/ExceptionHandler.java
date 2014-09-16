
public final class ExceptionHandler {
	public static void stringToInteger(String str) {
		ExceptionHandler.print("can't convert `" + str + "` to integer");
	}
	
	private static void print(String message) {
		System.out.println(message);
	}
}
