package Assignment1;

public class PayPalPayment implements PaymentMethod {

    @Override
    public String name() {
        return "PayPal Payment";
    }

    @Override
    public boolean pay(int amount) {
        if (!PaymentMethod.isValidAmount(amount)) {
            System.out.println("Invalid amount for PayPal payment");
            return false;
        }

        System.out.println("Paid " + amount + " using PayPal");
        return true;
    }
}

