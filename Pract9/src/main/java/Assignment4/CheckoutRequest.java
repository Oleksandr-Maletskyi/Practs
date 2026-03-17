package Assignment4;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Builder
@Getter // Додаємо геттери, щоб можна було прочитати дані з об'єкта
public class CheckoutRequest {
    private final Long userId;
    private final List<Long> items;
    private final String shippingAddress;
    private final String promoCode;
    private final String paymentMethod;
}

// Приклад використання:
// CheckoutRequest request = CheckoutRequest.builder()
//     .userId(1L)
//     .items(List.of(101L, 102L))
//     .shippingAddress("Kyiv, Ukraine")
//     .build();
