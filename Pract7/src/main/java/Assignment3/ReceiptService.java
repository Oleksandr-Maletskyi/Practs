package Assignment3;

import java.io.IOException;

public class ReceiptService {

    public void generate(Order order) {

        try (ReceiptWriter writer =
                     new ReceiptWriter("receipt_" + order.id() + ".txt")) {

            writer.write("Receipt\n");
            writer.write("Order ID: " + order.id() + "\n");
            writer.write("User: " + order.userEmail() + "\n");
            writer.write("Total: " + order.totalCents() + "\n");

        } catch (IOException e) {

            throw new ReceiptGenerationException(
                    "Failed to generate receipt for orderId=" + order.id(),
                    e
            );
        }
    }
}
