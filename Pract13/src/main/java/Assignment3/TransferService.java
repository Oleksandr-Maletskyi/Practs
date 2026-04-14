package Assignment3;

class TransferService {

    public void transfer(Account from, Account to, int amount) {
        if (from.getId() == to.getId()) {
            throw new IllegalArgumentException("Неможливо здійснити переказ на той самий рахунок");
        }

        Account firstLock = from.getId() < to.getId() ? from : to;
        Account secondLock = from.getId() < to.getId() ? to : from;

        synchronized (firstLock) {
            System.out.printf("%s захопив лок на рахунок %d%n", Thread.currentThread().getName(), firstLock.getId());

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (secondLock) {
                System.out.printf("%s захопив лок на рахунок %d%n", Thread.currentThread().getName(), secondLock.getId());

                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.printf("%s успішно переказав %d з рахунку %d на %d%n",
                            Thread.currentThread().getName(), amount, from.getId(), to.getId());
                } else {
                    System.out.printf("%s: Недостатньо коштів на рахунку %d%n", Thread.currentThread().getName(), from.getId());
                }
            }
        }
    }
}

