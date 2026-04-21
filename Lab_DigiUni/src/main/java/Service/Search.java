package Service;

import Domain.*;
import Domain.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

import static Repository.Validator.readValidInt;
import static Repository.Validator.readValidString;

public class Search {
    private static final Logger logger = LogManager.getLogger();
    public static List<Student> findStudentsByPib(University university) {
        Scanner scanner = new Scanner(System.in);
        String surname = readValidString(scanner, "Введіть прізвище: ");
        String name = readValidString(scanner, "Введіть ім'я: ");
        String fatherName = readValidString(scanner, "Введіть по-батькові: ");
        logger.info("Шукано студента за ПІБ {} {} {}", surname, name, fatherName);
        return university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getStudents().stream())
                .filter(student -> student.getSurname().equalsIgnoreCase(surname)
                        && student.getName().equalsIgnoreCase(name)
                        && student.getFatherName().equalsIgnoreCase(fatherName))
                .toList();
    }

    public static List<Teacher> findTeachersByPib(University university) {
        Scanner scanner = new Scanner(System.in);
        String surname = readValidString(scanner, "Введіть прізвище: ");
        String name = readValidString(scanner, "Введіть ім'я: ");
        String fatherName = readValidString(scanner, "Введіть по-батькові: ");
        logger.info("Шукано викладача за ПІБ {} {} {}", surname, name, fatherName);
        return university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getTeachers().stream())
                .filter(teacher -> teacher.getSurname().equalsIgnoreCase(surname)
                        && teacher.getName().equalsIgnoreCase(name)
                        && teacher.getFatherName().equalsIgnoreCase(fatherName))
                .toList();
    }

    public static List<Student> findStudentsByCourse(University university) {
        Scanner scanner = new Scanner(System.in);
        int course = readValidInt(scanner, "Введіть курс: ", 1, 6);
        logger.info("Шукано студента за курсом {}", course);
        return university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getStudents().stream())
                .filter(student -> student.getCourse() == course)
                .toList();
    }

    public static List<Student> findStudentsByGroup(University university) {
        Scanner scanner = new Scanner(System.in);
        int group = readValidInt(scanner, "Введіть групу: ", 1, 6);
        logger.info("Шукано студента за групою {}", group);
        return university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getStudents().stream())
                .filter(student -> student.getGroup() == group)
                .toList();
    }
}
