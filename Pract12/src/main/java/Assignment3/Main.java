package Assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path inboxDir = Paths.get("practical-data", "inbox");
        Path archiveDir = Paths.get("practical-data", "archive");

        try {
            Files.createDirectories(inboxDir);

            Files.writeString(inboxDir.resolve("temp-data1.tmp"), "тимчасовий файл 1");
            Files.writeString(inboxDir.resolve("temp-data2.tmp"), "тимчасовий файл 2");

            Files.writeString(inboxDir.resolve("report.txt"), "важливий звіт");
            Files.writeString(inboxDir.resolve("readme.txt"), "інструкція");

            System.out.println("Тестові файли створено в директорії: " + inboxDir.toAbsolutePath());
            System.out.println("Починаємо архівацію...\n");

            InboxArchiver.archiveTmpFiles(inboxDir, archiveDir);

            System.out.println("\nАрхівація завершена! Перевірте папку " + archiveDir.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Помилка при роботі з файловою системою: " + e.getMessage());
        }
    }
}