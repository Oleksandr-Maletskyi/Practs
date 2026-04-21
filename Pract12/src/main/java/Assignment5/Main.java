package Assignment5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path statusFile = Paths.get("status.bin");
        int N = 20;
        long targetIndex = 5;
        byte newStatus = 7;

        try {
            byte[] initialData = new byte[N];
            Files.write(statusFile, initialData);
            System.out.println("Файл створено: " + N + " байтів (усі дорівнюють 0).");

            StatusFile.updateStatus(statusFile, targetIndex, newStatus);
            System.out.println("Записано значення " + newStatus + " за індексом " + targetIndex + ".");

            byte readBackStatus = StatusFile.readStatus(statusFile, targetIndex);
            System.out.println("Прочитане значення: " + readBackStatus);

            if (readBackStatus == newStatus) {
                System.out.println("Перевірка успішна! Байт у файлі оновлено коректно.");
            } else {
                System.out.println("Помилка: значення не збігаються.");
            }

        } catch (IOException e) {
            System.err.println("Помилка вводу/виводу: " + e.getMessage());
        }
    }
}
