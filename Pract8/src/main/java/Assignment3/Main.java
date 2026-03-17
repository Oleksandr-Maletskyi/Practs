package Assignment3;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();
        String commonEmail = "alex@mail.com";

        registry.addStudent(new Student("1", "Alex"), commonEmail);

        boolean isAddedDuplicate = registry.addStudent(new Student("2", "Max"), commonEmail);
        System.out.println("Дублікат email додано? " + isAddedDuplicate); // false

        registry.removeById("1");
        System.out.println("Після видалення email існує? " + registry.containsEmail(commonEmail)); // false

        boolean isAddedNow = registry.addStudent(new Student("3", "Oleg"), commonEmail);
        System.out.println("Чи можна використати email знову? " + isAddedNow); // true


        HashSet<Student> set = new HashSet<>();
        Student s1 = new Student("1", "Олександр");
        Student s2 = new Student("1", "Олександр"); // однаковий ID
        Student s3 = new Student("2", "Марія"); // однаковий ID

        set.add(s1);
        set.add(s2);
        set.add(s3);

        System.out.println("Кількість студентів у HashSet: " + set.size());
// Виведе: 1, бо hashCode та equals однакові
    }
}
