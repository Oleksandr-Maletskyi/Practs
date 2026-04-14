package Assignment1;

import java.util.List;

public class Main {
    private static int sumResult = 0;
    private static int maxResult = 0;

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1L, 1500),
                new Order(2L, 4200),
                new Order(3L, 850),
                new Order(4L, 9100),
                new Order(5L, 3300)
        );

        Runnable sumTask = () -> {
            System.out.println("Потік суми почав роботу...");
            int sum = 0;
            for (Order order : orders) {
                sum += order.totalCents();
            }
            sumResult = sum;
            System.out.println("Потік суми завершив роботу.");
        };

        Runnable maxTask = () -> {
            System.out.println("Потік максимуму почав роботу...");
            int max = 0;
            for (Order order : orders) {
                if (order.totalCents() > max) {
                    max = order.totalCents();
                }
            }
            maxResult = max;
            System.out.println("Потік максимуму завершив роботу.");
        };

        System.out.println("--- Запуск паралельних задач ---");
        TaskRunner.runAndWait(List.of(sumTask, maxTask));
        System.out.println("--- Всі задачі завершено ---");

        System.out.println("Загальна сума (у центах): " + sumResult);
        System.out.println("Максимальне замовлення (у центах): " + maxResult);
    }
}
