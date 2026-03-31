import java.util.List;

public class Assignment1 {

    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Clean Code", "Robert Martin", 2008, List.of("clean", "practice", "java")),
                new Book("Effective Java", "Joshua Bloch", 2018, List.of("java", "best", "api")),
                new Book("Modern Java", "Nicolai Parlog", 2020, List.of("java", "streams", "records")),
                new Book("Java Concurrency", "Brian Goetz", 2006, List.of("concurrency", "java"))
        );


        List<String> result = books.stream()
                .peek(book -> System.out.println("--- Зайшло у стрім: " + book.title() +" "+ book.year() + " ---"))
                .filter(book -> book.year() > 2015)
                .peek(book -> System.out.println("--- Після 2015: " + book.title() +" "+ book.year() + " ---"))
                .map(book -> book.title().toUpperCase())
                .peek(title -> System.out.println("--- Заголовок великим буквами: " + title + " ---"))
                .sorted()
                .peek(title -> System.out.println("--- Відсортовано: " + title + " ---"))
                .limit(3)
                .peek(title -> System.out.println("--- Не більше 3: " + title + " ---"))
                .toList();

        System.out.println("--- Результат ---" + "\n" + result);
    }
}
