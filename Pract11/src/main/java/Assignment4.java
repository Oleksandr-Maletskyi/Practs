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

        Map<Boolean, Long> counts = results.stream()
                .peek(r -> System.out.println("Аналізуємо елемент: " + r.getClass().getSimpleName()))
                .collect(Collectors.partitioningBy(
                        r -> r instanceof Success,
                        Collectors.counting()
                ));

        System.out.println("Кількість Success: " + counts.get(true));
        System.out.println("Кількість Failure: " + counts.get(false));

        System.out.println("\n--- Повідомлення з Failure ---");

        List<String> failureMessages = results.stream()
                .peek(r -> System.out.println("Зайшло у стрім: " + r.getClass().getSimpleName()))
                .filter(r -> r instanceof Failure)
                .peek(r -> System.out.println("Пройшло фільтр!"))
                .map(r -> ((Failure) r).message())
                .peek(msg -> System.out.println(" Витягнуто текст: " + msg + "\n"))
                .toList();

        System.out.println("Фінальний список повідомлень: " + failureMessages);
    }
}
