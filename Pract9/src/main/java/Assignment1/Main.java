package Assignment1;

public class Main {
    public static void main (String[] args){
        Car BMW = new Car(5);
        Car.Engine engine = BMW.spec(625);
        System.out.println("Car model: " + BMW.model);
        System.out.println("Specs: " + engine);

        Library myLibrary = new Library("Олександрійська біліотека");
        Library.Book myBook = myLibrary.new Book("Кобзар", "Шевченко");
        System.out.println(myBook.bookLabel());
    }
}
