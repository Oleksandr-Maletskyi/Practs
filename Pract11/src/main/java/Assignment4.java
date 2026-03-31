import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment4 {

    public static void main(String[] args) {
        List<Result> results = List.of(
                new Success("Файл завантажено"),
                new Failure("Помилка з'єднання з сервером"),
                new Success("Дані оновлено"),
                new Failure("Невірний пароль"),
                new Failure("Таймаут бази даних")
        );

        System.out.println("--- Підрахунок успіхів та помилок ---");

        long successCount = results.stream().filter(r -> r instanceof Success).count();
        long failureCount = results.stream().filter(r -> r instanceof Failure).count();

        System.out.println("Кількість Success: " + successCount);
        System.out.println("Кількість Failure: " + failureCount);

        System.out.println("\n--- Повідомлення з Failure ---");

        List<String> failureMessages = results.stream()
                .filter(r -> r instanceof Failure)
                .map(r -> (Failure) r)
                .map(Failure::message)
                .toList();

        System.out.println(failureMessages);
    }
}
