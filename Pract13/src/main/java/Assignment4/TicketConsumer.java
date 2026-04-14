package Assignment4;

import java.util.concurrent.ConcurrentHashMap;

class TicketConsumer implements Runnable {
    private final TicketQueue queue;
    private final ConcurrentHashMap<String, Integer> topicCounts;
    private final String name;

    public TicketConsumer(TicketQueue queue, ConcurrentHashMap<String, Integer> topicCounts, String name) {
        this.queue = queue;
        this.topicCounts = topicCounts;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                SupportTicket ticket = queue.take();

                if (ticket == TicketQueue.POISON_PILL) {
                    System.out.println(name + ": Отримано POISON_PILL. Завершую роботу.");
                    break;
                }

                topicCounts.merge(ticket.topic(), 1, Integer::sum);

                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(name + " перервано.");
        }
    }
}
