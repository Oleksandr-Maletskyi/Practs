package Assignment2;

public class Main {
    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();

        String id = system.buildTicketId("1234");
        System.out.println("Generated ID: " + id);

        Runnable action = system.runOnce();
        action.run();
    }
}
