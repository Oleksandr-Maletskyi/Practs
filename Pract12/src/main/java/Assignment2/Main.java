package Assignment2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path inputCsv = Paths.get("payments.csv");
        Path reportOut = Paths.get("report.txt");

        // Тестові дані, які ми запишемо у файл
        String csvContent = """
                id,email,status,amountCents
                1,user1@mail.com,NEW,1500
                2,user2@mail.com,PAID,2000
                3,bad-email,UNKNOWN_STATUS,500
                4,user4@mail.com,FAILED,1000
                5,user5@mail.com,PAID,500
                6,user6@mail.com,NEW,3000
                """;

        try {
            // 1. Створюємо CSV-файл із тестовими даними (перезапише, якщо вже існує)
            Files.writeString(inputCsv, csvContent);
            System.out.println("Тестовий файл успішно створено: " + inputCsv.toAbsolutePath());

            // 2. Читаємо цей файл через наш парсер із Завдання 1
            PaymentLoadResult result = PaymentLoader.loadWithStats(inputCsv);
            System.out.println("Дані зчитано. Знайдено платежів: " + result.payments().size() +
                    ", невалідних рядків: " + result.invalidLines());

            // 3. Формуємо звіт (Завдання 2)
            PaymentReportWriter.writeReport(reportOut, result.payments(), result.invalidLines());
            System.out.println("Звіт успішно сформовано: " + reportOut.toAbsolutePath());

        } catch (Exception e) {
            System.err.println("Сталася помилка під час виконання: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
