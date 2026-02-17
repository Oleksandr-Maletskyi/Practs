package Assignment4;

import java.util.Objects;

public final class Money {
    private final long cents;

    // Приватний конструктор, використовуйте статики ofDollars
    private Money(long cents) {
        this.cents = cents;
    }

    // Створення грошей з доларів (наприклад, 10.50)
    public static Money ofDollars(double dollars) {
        return new Money(Math.round(dollars * 100));
    }

    public static Money zero() {
        return new Money(0);
    }

    // Множення для розрахунку відсотків
    public Money multiply(double factor) {
        return new Money(Math.round(this.cents * factor));
    }

    public long cents() {
        return cents;
    }

    // Методи equals та hashCode обов'язкові для assertEquals у тестах
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return cents == money.cents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cents);
    }

    @Override
    public String toString() {
        return String.format("$%.2f", cents / 100.0);
    }
}
