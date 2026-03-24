package Assignment4;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeLab {

    public static Instant toInstant(Event e) {
        return e.getStart().atZone(e.getZone()).toInstant();
    }

    public static long minutesBetween(Event a, Event b) {
        Instant startA = toInstant(a);
        Instant startB = toInstant(b);

        return Math.abs(Duration.between(startA, startB).toMinutes());
    }

    public static ZonedDateTime startInZone(Event e, String targetZoneString) {
        ZoneId targetZone = ZoneId.of(targetZoneString);
        ZonedDateTime originalTime = e.getStart().atZone(e.getZone());

        return originalTime.withZoneSameInstant(targetZone);
    }
}
