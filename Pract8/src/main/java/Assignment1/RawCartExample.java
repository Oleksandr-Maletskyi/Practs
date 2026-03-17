package Assignment1;

import java.util.ArrayList;
import java.util.List;

public class RawCartExample {
    public static void main(String[] args) {
      List cart = new ArrayList();      // сирий List
        cart.add("Hello");                // String
        cart.add(42);                     // Integer

        // Ми "віримо", що всередині зберігаються лише рядки
        for (Object o : cart) {
            String s = (String) o;        // ClassCastException на елементі 42
            System.out.println(s.toUpperCase());
        }
        /*List<String> cart = new ArrayList();
        cart.add("Hello");                // String
        //cart.add(42);                     // Integer

        for (String s : cart) {                  // каст більше не потрібен
            System.out.println(s.toUpperCase());
        }*/
    }
    /* Тобто за допомогою Дженеріків ми не отримуємо ClassCastException,
       просто не дає додати елемент не того типу до списку і викликати список
       можна без касту.
    */
}
