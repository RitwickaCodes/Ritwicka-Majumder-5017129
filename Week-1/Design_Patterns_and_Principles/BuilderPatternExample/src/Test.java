
public class Test {
	public static void main(String[] args) {
		Computer personalComputer = new Computer.Builder()
				.setCPU("Intel I5")
				.setRAM("16GB")
				.setStorage("512GB SSD")
				.build();
		System.out.println("Personal Computer: "+personalComputer);
	}
}
