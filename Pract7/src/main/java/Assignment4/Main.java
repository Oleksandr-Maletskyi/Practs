package Assignment4;

public class Main {
    // Створюємо логер для цього класу через фабрику
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Приклад успішного checkout
        log.info("User {} successfully checked out with card {}", "Alice", "1234-5678-9012-3456");

        // Приклад очікуваної відмови
        log.warn("Card {} was declined for user {}", "0123-4567-8901-2345", "Bob");

        // Приклад помилки (інцидент)
        log.error("Checkout failed for user {} due to {}", "Charlie", "Gateway timeout");

        // Пароль/токен не логуються
        log.info("User {} used password {}", "Dave", "mySecretPassword");
        log.info("User {} used token {}", "Eve", "token123");
    }
}
