package Assignment1;

public class Main {

    public static void main(String[] args) {

        Order validOrder = new Order(5, "sashko@mail.com", 25);
        System.out.println("Valid order created: " + validOrder);

        try {
            Order invalidOrder = new Order(0, "sashkomail.com", -10);
            System.out.println("Invalid order created: " + invalidOrder);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
