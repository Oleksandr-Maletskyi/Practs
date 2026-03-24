package Assignment2;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class EventLab {

    public static List<Event> pick(List<Event> events, Predicate<Event> condition) {
        return events.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    public static List<String> labels(List<Event> events, Function<Event, String> formatter) {
        return events.stream()
                .map(formatter)
                .collect(Collectors.toList());
    }

    public static void notifyAll(List<Event> events, Consumer<Event> action) {
        events.forEach(action);
    }

    public static Event create(Supplier<Event> supplier) {
        return supplier.get();
    }

    public static List<String> findConflicts(List<Event> events) {
        List<String> conflicts = new ArrayList<>();

        for (int i = 0; i < events.size(); i++) {
            for (int j = i + 1; j < events.size(); j++) {
                Event e1 = events.get(i);
                Event e2 = events.get(j);

                ZonedDateTime start1 = ZonedDateTime.of(e1.getStart(), e1.getZone());
                ZonedDateTime end1 = e1.end();

                ZonedDateTime start2 = ZonedDateTime.of(e2.getStart(), e2.getZone());
                ZonedDateTime end2 = e2.end();

                if (start1.isBefore(end2) && end1.isAfter(start2)) {
                    conflicts.add("Конфлікт: '" + e1.label() + "' перетинається з '" + e2.label() + "'");
                }
            }
        }
        return conflicts;
    }
}
