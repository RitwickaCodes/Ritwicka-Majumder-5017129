
public class Test {

	public static void main(String[] args) {
		Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("Sending notifications using Email and SMS:");
        smsNotifier.send("This is a test message.");

        System.out.println("\nSending notifications using Email, SMS, and Slack:");
        slackNotifier.send("This is another test message.");
	}

}
