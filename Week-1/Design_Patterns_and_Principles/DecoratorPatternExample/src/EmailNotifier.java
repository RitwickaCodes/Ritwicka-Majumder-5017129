
public class EmailNotifier implements Notifier{
	public void send(String message) {
		System.out.println("A new Email notification: "+message);
	}

}
