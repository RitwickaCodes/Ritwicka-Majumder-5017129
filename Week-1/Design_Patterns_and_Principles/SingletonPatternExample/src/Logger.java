public class Logger {
	private static Logger instance; // private static instance of itself
	private Logger() {} // ensuring the constructor is private
	public static Logger getInstance() {     //static method to get the instance of the class
		if(instance==null) {
			instance = new Logger();
		}
		return instance;
	}
}
