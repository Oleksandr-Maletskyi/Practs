package Assignment2;

public class OrderService {
    public void checkout(Order order) {

        try {
            processPayment(order);
            System.out.println("Payment successful for order " + order.id());

        } catch (PaymentGatewayException e) {

            System.err.println("ERROR: Payment failed for orderId="
                    + order.id()
                    + ", userEmail="
                    + order.userEmail());

            e.printStackTrace();

            throw new OrderProcessingException(
                    "Failed to process order",
                    order.id(),
                    order.userEmail(),
                    e   // chaining
            );
        }
    }

    private void processPayment(Order order)
            throws PaymentGatewayException {

        // симуляція помилки
        throw new PaymentGatewayException("Payment provider timeout");
    }
}
