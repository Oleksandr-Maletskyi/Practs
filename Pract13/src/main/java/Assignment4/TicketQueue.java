package Assignment4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class TicketQueue {
    public static final SupportTicket POISON_PILL = new SupportTicket(-1L, "SYSTEM", "SHUTDOWN");

    private final BlockingQueue<SupportTicket> queue = new LinkedBlockingQueue<>(50);

    public void put(SupportTicket ticket) throws InterruptedException {
        queue.put(ticket);
    }

    public SupportTicket take() throws InterruptedException {
        return queue.take();
    }
}
