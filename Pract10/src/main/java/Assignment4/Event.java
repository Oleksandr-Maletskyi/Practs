package Assignment4;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Event {
    private String title;
    private LocalDateTime start;
    private int durationMinutes;
    private ZoneId zone;
    private String track;

    public Event(String title, LocalDateTime start, int durationMinutes, ZoneId zone, String track) {
        this.title = title;
        this.start = start;
        this.durationMinutes = durationMinutes;
        this.zone = zone;
        this.track = track;
    }

    public ZonedDateTime end() {
        return ZonedDateTime.of(start, zone).plusMinutes(durationMinutes);
    }

    public String label() {
        return title + " [" + track + "]";
    }

    public String getTitle() { return title; }
    public LocalDateTime getStart() { return start; }
    public int getDurationMinutes() { return durationMinutes; }
    public ZoneId getZone() { return zone; }
    public String getTrack() { return track; }

    @Override
    public String toString() {
        return label() + " | Початок: " + ZonedDateTime.of(start, zone) + " | Кінець: " + end();
    }
}
