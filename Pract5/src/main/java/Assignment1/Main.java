package Assignment1;

public class Main {
    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        PaymentMethod card = new CardPayment();
        PaymentMethod paypal = new PayPalPayment();

        processor.process(card, 100);
        processor.process(paypal, 200);
        card.payWithFee(100, 10);
        paypal.payWithFee(200, 20);
    }
}

