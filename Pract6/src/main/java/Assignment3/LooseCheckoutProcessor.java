package Assignment3;

import java.util.Objects;

public class LooseCheckoutProcessor {
    private final PaymentGateway gateway;
    private final NotificationService notifier;

    public LooseCheckoutProcessor(PaymentGateway gateway, NotificationService notifier) {
        this.gateway = Objects.requireNonNull(gateway, "gateway");
        this.notifier = Objects.requireNonNull(notifier, "notifier");
    }

    public PaymentResult checkout(Order order, PaymentDetails details, Email email) {
        Money total = order.total();
        PaymentResult result = gateway.charge(total, details);
        if (result.isSuccess()) {
            notifier.sendReceipt(email, total);
        }
        return result;
    }
}
/* Клас використовує інтерфейси тому приймає будь-які методи оплати які є в інтерфейсі
   і не потребуй змін при додаванні нового способу оплати, також його можна легко протестувати.
*/