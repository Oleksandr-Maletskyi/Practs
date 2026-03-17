package Assignment2;

public class TicketSystem {

    public String buildTicketId(String base) {

        class IdBuilder {
            String build() {
                return base;
            }
        }

        IdBuilder builder = new IdBuilder();
        return builder.build();
    }

    public Runnable runOnce() {
        String message = "Квиток активовано!";

        return new Runnable() {
            @Override
            public void run() {
                System.out.println(message);
            }
        };
    }
}
