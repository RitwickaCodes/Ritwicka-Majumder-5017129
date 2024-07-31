public class Test {

	public static void main(String[] args) {
		Logger logger1 = Logger.getInstance();
		Logger logger2 = Logger.getInstance();
		if(logger1==logger2) {
			System.out.println("Same Instance");
		}
		else {
			System.out.println("Different Instance");
		}

	}

}
