package Assignment4;

import Assignment2.AppException;

public class OrderProcessingException extends AppException {
    private final int orderId;
    private final String userEmail;

    public OrderProcessingException(String message, int orderId, String userEmail, Throwable cause) {
        super(message, cause);
        this.orderId = orderId;
        this.userEmail = userEmail;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
