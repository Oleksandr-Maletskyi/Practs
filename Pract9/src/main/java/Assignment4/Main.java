package Assignment4;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserDto user = new UserDto(1L, "alex_m", "alex@mail.com", "USER");
        System.out.println("User: " + user);

        Price price = new Price(new BigDecimal("99.99"), "UAH");
        System.out.println("Price: " + price.getAmount() + " " + price.getCurrency());

        CheckoutRequest req = CheckoutRequest.builder()
                .userId(user.getId())
                .items(List.of(101L, 102L))
                .shippingAddress("Kyiv")
                .build();

        System.out.println("Checkout for User " + req.getUserId() + " to " + req.getShippingAddress());

        System.out.println("Prices equal? " + price.equals(new Price(new BigDecimal("99.99"), "UAH")));
    }
}
