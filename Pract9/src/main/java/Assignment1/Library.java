package Assignment1;

public class Library {
    private final String name;

    public Library(String name) {
        this.name = name;
    }

    public class Book{
        public final String title;
        public final String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
        public String bookLabel() {
            return "Книга: '" + title + "' (" + author + ") | Бібліотека: " + name;
        }
    }
}
