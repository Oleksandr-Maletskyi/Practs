package Assignment2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PaymentReportWriter {

    public static void writeReport(Path out, List<Payment> payments, int invalidLines) throws IOException {
        long paidTotalCents = payments.stream()
                .filter(p -> p.status() == PaymentStatus.PAID)
                .mapToLong(Payment::amountCents)
                .sum();

        Map<PaymentStatus, Long> counts = payments.stream()
                .collect(Collectors.groupingBy(Payment::status, Collectors.counting()));

        long countNew = counts.getOrDefault(PaymentStatus.NEW, 0L);
        long countPaid = counts.getOrDefault(PaymentStatus.PAID, 0L);
        long countFailed = counts.getOrDefault(PaymentStatus.FAILED, 0L);

        Path tempFile = out.resolveSibling(out.getFileName() + ".tmp");

        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("invalidLines=" + invalidLines);
            writer.newLine();

            writer.write("paidTotalCents=" + paidTotalCents);
            writer.newLine();

            writer.write(String.format("NEW=%d, PAID=%d, FAILED=%d",
                    countNew, countPaid, countFailed));
            writer.newLine();
        }

        Files.move(tempFile, out,
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.ATOMIC_MOVE);
    }
}
