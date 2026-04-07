package Repository;

import Domain.Form;
import Domain.State;
import Domain.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class StudentService {
    public void createStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть прізвище: ");
        String surname = scanner.nextLine();
        System.out.println("Введіть ім'я: ");
        String name = scanner.nextLine();
        System.out.println("Введіть по-батькові: ");
        String fatherName = scanner.nextLine();
        System.out.println("Введіть рік народження: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введіть місяць народження: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введіть день народження: ");
        int day = Integer.parseInt(scanner.nextLine());

        LocalDate newDate = LocalDate.of(year, month, day);
        Student newStudent = new Student(surname, name, fatherName, birthDate, email, number, course, group, vstupDate, form, state);

    }
}
