package Assignment3;

public class Main {

    public static void main(String[] args) {

        Order order = new Order(1, "sashko@mail.com", 250);

        ReceiptService receiptService = new ReceiptService();

        try {
            receiptService.generate(order);
            System.out.println("Receipt generated successfully.");

        } catch (ReceiptGenerationException e) {

            System.out.println("Receipt generation failed!");
            System.out.println("Message: " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println("Root cause: " + e.getCause());
            }
        }
    }
}
