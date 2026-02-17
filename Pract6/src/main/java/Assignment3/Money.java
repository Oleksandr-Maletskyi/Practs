package Assignment3;

public final class Money {
    private final long cents;

    public Money(long cents) {
        if (cents < 0) {
            throw new IllegalArgumentException("Amount must be >= 0");
        }
        this.cents = cents;
    }

    public static Money zero() {
        return new Money(0);
    }

    public static Money ofDollars(double dollars) {
        return new Money(Math.round(dollars * 100));
    }

    public Money add(Money other) {
        return new Money(this.cents + other.cents);
    }

    public Money multiply(int factor) {
        return new Money(this.cents * factor);
    }

    public Money multiply(double factor) {
        return new Money(Math.round(this.cents * factor));
    }
}
