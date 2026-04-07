package Assignment4;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path baseDir = Paths.get("user-files");

        System.out.println("Базова директорія: " + baseDir.toAbsolutePath().normalize() + "\n");

        String safeInput = "reports/2025.txt";
        try {
            Path safePath = PathSafety.safeResolve(baseDir, safeInput);
            System.out.println("Успішно! Дозволений шлях: " + safePath);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }

        String maliciousInput = "../secret.txt";
        try {
            Path maliciousPath = PathSafety.safeResolve(baseDir, maliciousInput);
            System.out.println("Успішно! Дозволений шлях: " + maliciousPath);
        } catch (IllegalArgumentException e) {
            System.err.println("Заблоковано: " + e.getMessage());
        }
    }
}
