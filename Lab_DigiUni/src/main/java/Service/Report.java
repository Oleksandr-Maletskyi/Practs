package Service;

import Domain.Department;
import Domain.Student;
import Domain.Teacher;
import Domain.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.Scanner;

import static Repository.Validator.readValidDepartment;
import static Repository.Validator.readValidInt;

public class Report {
    private static final Logger logger = LogManager.getLogger();
    public static void printStudentsSortedByCourse(University university) {
        System.out.println("--- Список всіх студентів за курсами ---");

        university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getStudents().stream())
                .sorted(Comparator.comparingInt(Student::getCourse))
                .forEach(System.out::println);
        logger.info("Виведено список всіх студентів за курсами");
    }
    public static void printStudentsSortedByAlphabet(University university) {
        System.out.println("--- Список всіх студентів за алфавітом ---");

        university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getStudents().stream())
                .sorted(Comparator.comparing(Student::getSurname, String.CASE_INSENSITIVE_ORDER)
                    .thenComparing(Student::getName, String.CASE_INSENSITIVE_ORDER)
                    .thenComparing(Student::getFatherName, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
        logger.info("Виведено список всіх студентів за алфавітом");
    }

    public static void printTeachersSortedByAlphabet(University university) {
        System.out.println("--- Список всіх викладачів за алфавітом ---");

        university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getTeachers().stream())
                .sorted(Comparator.comparing(Teacher::getSurname, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Teacher::getName, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Teacher::getFatherName, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
        logger.info("Виведено список всіх викладачів за алфавітом");
    }

    public static void printDepartmentStudentsByCourse(University university) {
        Scanner scanner = new Scanner(System.in);
        Department department = readValidDepartment(scanner, university);
        System.out.println("--- Студенти кафедри за курсами: " + department.getName() + " ---");

        department.getStudents().stream()
                .sorted(Comparator.comparingInt(Student::getCourse))
                .forEach(System.out::println);
        logger.info("Виведено список студентів кафедри {} за курсами", department.getName());
    }

    public static void printDepartmentStudentsByAlphabet(University university) {
        Scanner scanner = new Scanner(System.in);
        Department department = readValidDepartment(scanner, university);
        System.out.println("--- Студенти кафедри за алфавітом: " + department.getName() + " ---");

        department.getStudents().stream()
                .sorted(Comparator.comparing(Student::getSurname, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Student::getName, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Student::getFatherName, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
        logger.info("Виведено список студентів кафедри {} за алфавітом", department.getName());
    }

    public static void printDepartmentStudentsOfCourseByAlphabet(University university) {
        Scanner scanner = new Scanner(System.in);
        Department department = readValidDepartment(scanner, university);
        int course = readValidInt(scanner, "Введіть курс: ", 1, 6);
        System.out.println("--- Студенти кафедри вказаного курсу за алфавітом: " + department.getName() + " ---");

        department.getStudents().stream()
                .filter(student -> student.getCourse() == course)
                .sorted(Comparator.comparing(Student::getSurname, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Student::getName, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Student::getFatherName, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
        logger.info("Виведено список студентів кафедри {}, {} курсу за алфавітом", department.getName(), course);
    }

    public static void printDepartmentStudentsOfCourse(University university) {
        Scanner scanner = new Scanner(System.in);
        Department department = readValidDepartment(scanner, university);
        int course = readValidInt(scanner, "Введіть курс: ", 1, 6);
        System.out.println("--- Студенти кафедри вказаного курсу: " + department.getName() + " ---");

        department.getStudents().stream()
                .filter(student -> student.getCourse() == course)
                .sorted(Comparator.comparingLong(Student::getId))
                .forEach(System.out::println);
        logger.info("Виведено список студентів кафедри {}, {} курсу", department.getName(), course);
    }

    public static void printFacultiesAndDepartments(University university) {
        System.out.println("--- Список факультетів та їх кафедр ---");

        university.getFaculties().forEach(faculty -> {
            System.out.println("Факультет: " + faculty);

            if (faculty.getDepartments() == null || faculty.getDepartments().isEmpty()) {
                System.out.println("    Немає кафедр");
            } else {
                faculty.getDepartments().forEach(department ->
                        System.out.println("    Кафедра: " + department)
                );
            }
        });
        logger.info("Виведено список факультетів і їх кафедр");
    }

    public static void printAllAccounts(University university) {
        System.out.println("--- Список всіх акаунтів системи ---");

        if (university.getAccountsMap().isEmpty()) {
            System.out.println("    Жодного акаунта не створено");
            return;
        }

        university.getAccountsMap().values().forEach(System.out::println);
        logger.info("Виведено список акаунтів");
    }

}
