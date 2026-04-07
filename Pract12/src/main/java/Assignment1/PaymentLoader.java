package Assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PaymentLoader {

    public static List<Payment> load(Path csv) {
        return loadWithStats(csv).payments();
    }

    public static PaymentLoadResult loadWithStats(Path csv) {
        List<Payment> payments = new ArrayList<>();
        int invalidLines = 0;

        try (BufferedReader reader = Files.newBufferedReader(csv)) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    String[] parts = line.split(",");

                    if (parts.length != 4) {
                        throw new IllegalArgumentException("Некоректна кількість колонок");
                    }

                    String id = parts[0].trim();
                    String email = parts[1].trim();
                    PaymentStatus status = PaymentStatus.valueOf(parts[2].trim().toUpperCase());
                    long amountCents = Long.parseLong(parts[3].trim());

                    payments.add(new Payment(id, email, status, amountCents));

                } catch (Exception e) {
                    invalidLines++;
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }

        return new PaymentLoadResult(payments, invalidLines);
    }
}
