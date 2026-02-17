package Assignment1;

public class CardPayment implements PaymentMethod {

    @Override
    public String name() {
        return "Card Payment";
    }

    @Override
    public boolean pay(int amount) {
        if (!PaymentMethod.isValidAmount(amount)) {
            System.out.println("Invalid amount for card payment");
            return false;
        }

        System.out.println("Paid " + amount + " using card");
        return true;
    }
}


