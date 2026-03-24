package Assignment2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ZoneId kyivZone = ZoneId.of("Europe/Kyiv");
        ZoneId londonZone = ZoneId.of("Europe/London");

        List<Event> events = Arrays.asList(
                new Event("Java Time API", LocalDateTime.of(2026, 3, 25, 10, 0), 90, kyivZone, "Backend"),
                new Event("FI in Java", LocalDateTime.of(2026, 3, 25, 13, 30), 120, kyivZone, "Backend"),
                new Event("Global Sync", LocalDateTime.of(2026, 3, 25, 12, 0), 60, londonZone, "DevOps"),
                new Event("Soft Skills", LocalDateTime.of(2026, 3, 27, 18, 0), 45, kyivZone, "General")
        );

        Predicate<Event> isMorning = e -> e.getStart().getHour() < 12;

        Predicate<Event> isBackend = e -> e.getTrack().equals("Backend");
        Predicate<Event> isShort = e -> e.getDurationMinutes() <= 60;

        Predicate<Event> notMorningOrShort = isMorning.negate().or(isShort);
        Predicate<Event> morningBackend = isMorning.and(isBackend);

        System.out.println("--- Фільтрація (pick): Ранкові Backend події ---");
        List<Event> pickedEvents = EventLab.pick(events, morningBackend);
        EventLab.notifyAll(pickedEvents, e -> System.out.println(e.label()));

        System.out.println("\n--- Трансформація (labels) ---");
        List<String> eventLabels = EventLab.labels(events, Event::label);
        eventLabels.forEach(System.out::println);

        System.out.println("\n--- Створення (create) ---");
        Event newEvent = EventLab.create(() ->
                new Event("Late Night Code", LocalDateTime.now(), 120, kyivZone, "Fun")
        );
        System.out.println("Створено: " + newEvent.label());

        System.out.println("\n--- Пошук конфліктів (findConflicts) ---");
        List<String> conflicts = EventLab.findConflicts(events);
        conflicts.forEach(System.out::println);
    }
}