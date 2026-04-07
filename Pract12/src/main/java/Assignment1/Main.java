package Assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path tempCsv = Files.createTempFile("payments", ".csv");
        String csvContent = """
                id,email,status,amountCents
                1,test1@mail.com,NEW,1500
                2,test2@mail.com,PAID,2000
                
                3,bad-email,UNKNOWN_STATUS,500
                4,test4@mail.com,FAILED,not_a_number
                5,test5@mail.com,NEW,100
                """;
        Files.writeString(tempCsv, csvContent);

        PaymentLoadResult result = PaymentLoader.loadWithStats(tempCsv);

        System.out.println("Кількість валідних платежів: " + result.payments().size());
        System.out.println("Кількість невалідних рядків (invalidLines): " + result.invalidLines());

        System.out.println("\nВалідні платежі:");
        result.payments().forEach(System.out::println);

        Files.deleteIfExists(tempCsv);
    }
}

