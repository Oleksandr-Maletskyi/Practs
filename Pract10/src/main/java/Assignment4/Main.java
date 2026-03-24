package Assignment4;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        ZoneId kyivZone = ZoneId.of("Europe/Kyiv");
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");

        Event eventKyiv = new Event(
                "Kyiv Morning Sync",
                LocalDateTime.of(2026, 3, 25, 10, 0),
                60,
                kyivZone,
                "Business"
        );

        Event eventTokyo = new Event(
                "Tokyo Evening Sync",
                LocalDateTime.of(2026, 3, 25, 18, 0), //це 11:00 за Києвом
                60,
                tokyoZone,
                "Business"
        );

        System.out.println("=== 1. Перевірка toInstant ===");
        System.out.println("Kyiv Instant:  " + DateTimeLab.toInstant(eventKyiv));
        System.out.println("Tokyo Instant: " + DateTimeLab.toInstant(eventTokyo));

        System.out.println("\n=== 2. Перевірка minutesBetween ===");

        long minutes = DateTimeLab.minutesBetween(eventKyiv, eventTokyo);
        System.out.println("Хвилин між подіями: " + minutes + " хв");

        System.out.println("\n=== 3. Перевірка startInZone ===");
        ZonedDateTime tokyoTimeInKyiv = DateTimeLab.startInZone(eventTokyo, "Europe/Kyiv");
        System.out.println("Подія 'Tokyo Evening Sync' за Києвом почнеться о: " + tokyoTimeInKyiv);
    }
}