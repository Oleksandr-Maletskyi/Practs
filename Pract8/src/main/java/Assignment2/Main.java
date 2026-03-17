package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");

        String first = GenericUtils.firstOrNull(strings);
        System.out.println("First element: " + first);


        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);

        double total = GenericUtils.sum(numbers);
        System.out.println("Sum: " + total);


        List<Integer> ids = new ArrayList<>();
        GenericUtils.addDefaultIds(ids);

        System.out.println("IDs: " + ids);
    }
}
