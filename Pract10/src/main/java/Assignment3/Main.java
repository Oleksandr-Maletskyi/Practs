package Assignment3;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ZoneId kyivZone = ZoneId.of("Europe/Kyiv");

        List<Event> events = new ArrayList<>(Arrays.asList(
                new Event("DevOps Track", LocalDateTime.of(2026, 3, 25, 15, 0), 60, kyivZone, "DevOps"),
                new Event("Morning Sync", LocalDateTime.of(2026, 3, 25, 9, 0), 30, kyivZone, "General"),
                new Event("Java Basics", LocalDateTime.of(2026, 3, 25, 11, 0), 90, kyivZone, "Backend")
        ));

        System.out.println("--- Початковий список ---");
        printEvents(events);

        System.out.println("\n=== 1. Виклик sortAnonymous ===");
        Collections.shuffle(events);
        System.out.println("До:");
        printEvents(events);

        LambdaRefactorLab.sortAnonymous(events);

        System.out.println("Після:");
        printEvents(events);

        System.out.println("\n=== 2. Виклик sortLambda ===");
        Collections.shuffle(events);
        System.out.println("До:");
        printEvents(events);

        LambdaRefactorLab.sortLambda(events);

        System.out.println("Після:");
        printEvents(events);

        System.out.println("\n=== 3. Виклик sortMethodRef ===");
        Collections.shuffle(events);
        System.out.println("До:");
        printEvents(events);

        LambdaRefactorLab.sortMethodRef(events);

        System.out.println("Після:");
        printEvents(events);
    }

    private static void printEvents(List<Event> events) {
        events.forEach(e -> System.out.println("  " + e.label() + " - " + e.getStart().toLocalTime()));
    }
}
