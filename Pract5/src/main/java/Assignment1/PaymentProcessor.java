package Assignment1;

public class PaymentProcessor {
    public boolean process(PaymentMethod method, int amount) {
        System.out.println("Processing payment via: " + method.name());
        return method.pay(amount);
    }
}
