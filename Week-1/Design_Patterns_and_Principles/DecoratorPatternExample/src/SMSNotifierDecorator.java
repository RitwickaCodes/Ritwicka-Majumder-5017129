
public class SMSNotifierDecorator extends NotifierDecorator{
	public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
	
	@Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }
    private void sendSMS(String message) {
        System.out.println("A new SMS notification: " + message);
    }

}
