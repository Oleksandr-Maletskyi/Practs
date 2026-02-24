package Assignment4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleLogger implements Logger {

    private final String name;
    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public SimpleLogger(String name) {
        this.name = name;
    }

    @Override
    public void info(String message, Object... args) {
        log("INFO", message, null, args);
    }

    @Override
    public void warn(String message, Object... args) {
        log("WARN", message, null, args);
    }

    @Override
    public void error(String message, Object... args) {
        log("ERROR", message, null, args);
    }

    @Override
    public void error(String message, Throwable t, Object... args) {
        log("ERROR", message, t, args);
    }

    private void log(String level, String message, Throwable t, Object... args) {

        String formattedMessage = format(message, args);

        System.out.println(LocalDateTime.now().format(FORMAT)
                + " [" + level + "] "
                + name + " - "
                + formattedMessage);

        if (t != null) {
            t.printStackTrace(System.out);
        }
    }

    private String format(String message, Object... args) {

        if (args == null || args.length == 0) {
            return message;
        }

        for (Object arg : args) {
            message = message.replaceFirst("\\{}",
                    arg == null ? "null" : arg.toString());
        }

        return message;
    }
}
