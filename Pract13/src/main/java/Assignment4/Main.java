package Assignment4;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketQueue queue = new TicketQueue();
        ConcurrentHashMap<String, Integer> stats = new ConcurrentHashMap<>();
        int numberOfConsumers = 3;

        Thread producerThread = new Thread(new TicketProducer(queue, numberOfConsumers), "Producer-Thread");

        Thread[] consumers = new Thread[numberOfConsumers];
        for (int i = 0; i < numberOfConsumers; i++) {
            consumers[i] = new Thread(new TicketConsumer(queue, stats, "Consumer-" + (i + 1)));
            consumers[i].start();
        }

        producerThread.start();

        producerThread.join();
        for (Thread consumer : consumers) {
            consumer.join();
        }

        System.out.println("\n=== Фінальна статистика по темах ===");
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " заявок");
        }
    }
}
