package Assignment3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account(1L, 1000);
        Account account2 = new Account(2L, 1000);
        TransferService service = new TransferService();

        System.out.println("Початковий баланс:");
        System.out.println("Рахунок 1: " + account1.getBalance());
        System.out.println("Рахунок 2: " + account2.getBalance());
        System.out.println("-------------------------");

        Thread thread1 = new Thread(() -> {
            service.transfer(account1, account2, 300);
        }, "Потік-A (1->2)");

        Thread thread2 = new Thread(() -> {
            service.transfer(account2, account1, 500);
        }, "Потік-B (2->1)");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("-------------------------");
        System.out.println("Фінальний баланс:");
        System.out.println("Рахунок 1 (очікується 1200): " + account1.getBalance());
        System.out.println("Рахунок 2 (очікується 800): " + account2.getBalance());
    }
}
