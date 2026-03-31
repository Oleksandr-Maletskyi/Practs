import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Assignment2 {

    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Clean Code", "Robert Martin", 2008, List.of("clean", "practice", "java")),
                new Book("Effective Java", "Joshua Bloch", 2018, List.of("java", "best", "api")),
                new Book("Modern Java", "Nicolai Parlog", 2020, List.of("java", "streams", "records")),
                new Book("Java Concurrency", "Brian Goetz", 2006, List.of("concurrency", "java"))
        );

        System.out.println("--- Унікальні відсортовані теги ---");
        List<String> uniqueSortedTags = books.stream()
                .flatMap(book -> book.tags().stream())
                .peek(tag -> System.out.println("--- Теги: " + tag + " ---"))
                .distinct()
                .peek(tag -> System.out.println("--- Теги без повторень: " + tag + " ---"))
                .sorted()
                .peek(tag -> System.out.println("--- Теги відсортовані: " + tag + " ---"))
                .toList();

        System.out.println("--- Унікальні відсортовані теги результат ---" + "\n" + uniqueSortedTags);


        System.out.println("\n--- Аналітика тегів ---");

        Map<String, Long> tagFrequency = books.stream()
                .flatMap(book -> book.tags().stream())
                .peek(tag -> System.out.println("--- Теги: " + tag + " ---"))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println("--- Аналітика тегів результат ---" + "\n" + tagFrequency);


        System.out.println("\n--- Топ-N тегів ---");

        tagFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .peek(tag -> System.out.println("--- Теги: " + tag + " ---"))
                .forEach(entry -> System.out.println("Результат: " + entry.getKey() + ": " + entry.getValue()));


        System.out.println("--- partitioningBy ---");

        Map<Boolean, List<Book>> recentVsOld = books.stream()
                .collect(Collectors.partitioningBy(b -> b.year() > 2015));

        System.out.println(recentVsOld);
    }
}