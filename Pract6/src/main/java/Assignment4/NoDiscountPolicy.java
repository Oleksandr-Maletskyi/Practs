package Assignment4;

public class NoDiscountPolicy implements DiscountPolicy {
    @Override
    public Money apply(Money basePrice) {
        return basePrice;
    }
}
