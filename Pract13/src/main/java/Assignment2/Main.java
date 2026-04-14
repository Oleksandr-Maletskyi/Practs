package Assignment2;

// 4. Головний клас для тестування
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Одиничний тест: Unsafe vs Safe ===");

        // Тестуємо Unsafe
        Inventory unsafe = new UnsafeInventory(100);
        runReservationTask(unsafe);
        System.out.println("Залишок UnsafeInventory: " + unsafe.available());

        // Тестуємо Safe
        Inventory safe = new SynchronizedInventory(100);
        runReservationTask(safe);
        System.out.println("Залишок SynchronizedInventory: " + safe.available());

        System.out.println("\n=== Стрес-тест (Stress-Harness) для UnsafeInventory ===");
        runStressTest(500);
    }

    private static void runReservationTask(Inventory inventory) throws InterruptedException {
        Thread t1 = new Thread(() -> inventory.reserve(60), "Потік-1");
        Thread t2 = new Thread(() -> inventory.reserve(60), "Потік-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private static void runStressTest(int iterations) throws InterruptedException {
        int violationsCount = 0;

        for (int i = 0; i < iterations; i++) {
            Inventory unsafe = new UnsafeInventory(100);
            runReservationTask(unsafe);

            // Перевіряємо інваріант: доступних товарів не може бути менше нуля
            if (unsafe.available() < 0) {
                violationsCount++;
            }
        }

        System.out.printf("Проведено ітерацій: %d%n", iterations);
        System.out.printf("Кількість порушень інваріанта (залишок < 0): %d%n", violationsCount);
        double violationRate = ((double) violationsCount / iterations) * 100;
        System.out.printf("Відсоток помилок: %.2f%%%n", violationRate);
    }
}
