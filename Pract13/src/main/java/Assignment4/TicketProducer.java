package Assignment4;

class TicketProducer implements Runnable {
    private final TicketQueue queue;
    private final int numConsumers;

    public TicketProducer(TicketQueue queue, int numConsumers) {
        this.queue = queue;
        this.numConsumers = numConsumers;
    }

    @Override
    public void run() {
        String[] topics = {"Billing", "Tech Support", "Sales", "General Query"};

        try {
            System.out.println("Producer: Починаю генерувати заявки...");
            for (int i = 1; i <= 20; i++) {
                String topic = topics[i % topics.length];
                SupportTicket ticket = new SupportTicket(i, "Customer-" + i, topic);
                queue.put(ticket);
                System.out.println("Producer: Відправлено " + ticket);
                Thread.sleep(10);
            }

            System.out.println("Producer: Усі заявки відправлено. Надсилаю POISON_PILLs...");
            for (int i = 0; i < numConsumers; i++) {
                queue.put(TicketQueue.POISON_PILL);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer перервано.");
        }
    }
}
