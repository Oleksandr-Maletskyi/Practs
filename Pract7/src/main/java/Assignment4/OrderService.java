package Assignment4;

public class OrderService {

    private static final Logger log =
            LoggerFactory.getLogger(OrderService.class);

    public void checkout(Order order) {

        try {
            processPayment(order);

            log.info("Checkout successful for orderId={}, userEmail={}",
                    order.id(),
                    order.userEmail());

        } catch (CardDeclinedException e) {

            log.warn("Card declined for orderId={}, userEmail={}",
                    order.id(),
                    order.userEmail());

        } catch (PaymentGatewayTimeoutException e) {

            log.error("Gateway timeout for orderId={}, userEmail={}",
                    e,
                    order.id(),
                    order.userEmail());

            throw new OrderProcessingException(
                    "Payment timeout",
                    order.id(),
                    order.userEmail(),
                    e);
        }
    }

    private void processPayment(Order order)
            throws CardDeclinedException, PaymentGatewayTimeoutException {

        // Симуляція:
        throw new PaymentGatewayTimeoutException("Gateway did not respond");
    }
}
