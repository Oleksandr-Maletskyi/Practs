package Assignment1;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        ZoneId kyivZone = ZoneId.of("Europe/Kyiv");
        ZoneId londonZone = ZoneId.of("Europe/London");

        Event event1 = new Event(
                "Java Time API Basics",
                LocalDateTime.of(2026, 3, 25, 10, 0),
                90,
                kyivZone,
                "Backend Track"
        );

        Event event2 = new Event(
                "Functional Interfaces (FI) in Java",
                LocalDateTime.of(2026, 3, 25, 13, 30),
                120,
                kyivZone,
                "Backend Track"
        );

        Event event3 = new Event(
                "Global Deployment Strategies",
                LocalDateTime.of(2026, 3, 26, 15, 0),
                60,
                londonZone,
                "DevOps Track"
        );

        Event event4 = new Event(
                "Soft Skills for Engineers",
                LocalDateTime.of(2026, 3, 27, 18, 0),
                45,
                kyivZone,
                "General Track"
        );

        Event[] events = {event1, event2, event3, event4};

        for (Event event : events) {
            System.out.println("Label: " + event.label());
            System.out.println("End Time: " + event.end());
            System.out.println("---");
        }
    }
}
