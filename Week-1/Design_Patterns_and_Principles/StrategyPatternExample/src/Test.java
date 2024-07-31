
public class Test {

	public static void main(String[] args) {
		PaymentContext paymentContext = new PaymentContext();
		
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876", "Ram Das");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(500.00);

        PaymentStrategy payPalPayment = new PayPalPayment("ram.das@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(600.00);

	}

}
