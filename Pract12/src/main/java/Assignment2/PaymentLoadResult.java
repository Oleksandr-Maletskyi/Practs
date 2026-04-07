package Assignment2;

import java.util.List;

public record PaymentLoadResult(List<Payment> payments, int invalidLines) {

}
