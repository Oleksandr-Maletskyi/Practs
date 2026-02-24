package Assignment2;

public class Main {

    public static void main(String[] args) {

        Order order = new Order(1, "sashko@mail.com", 100);

        OrderService service = new OrderService();

        service.checkout(order);
    }
}
