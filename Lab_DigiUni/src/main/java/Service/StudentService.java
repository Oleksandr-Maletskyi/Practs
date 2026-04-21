package Service;

import Domain.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Scanner;

import static Domain.Form.*;
import static Domain.State.*;
import static Repository.Validator.*;

public class StudentService implements Service {
    private static final Logger logger = LogManager.getLogger();
    public  static void create(University university){
        Scanner scanner = new Scanner(System.in);
        boolean createStudent = readValidConfirmation(scanner, "Введіть 1 якщо хочете створити студента, введіть 0 якщо ні: ");
        if (createStudent) {
            long id = university.getNextStudentId();
            String surname = readValidString(scanner, "Введіть прізвище: ");
            String name = readValidString(scanner, "Введіть ім'я: ");
            String fatherName = readValidString(scanner, "Введіть по-батькові: ");
            int birthYear = readValidInt(scanner, "Введіть рік народження: ", 1900, 2026);
            int birthMonth = readValidInt(scanner, "Введіть місяць народження: ", 1, 12);
            int birthDay = readValidInt(scanner, "Введіть день народження: ", 1, 31);
            LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
            String email = readValidString(scanner, "Введіть пошту: ");
            int number = readValidInt(scanner, "Введіть номер: ", 1, 10000000);
            int course = readValidInt(scanner, "Введіть курс: ", 1, 6);
            int group = readValidInt(scanner, "Введіть групу: ", 1, 6);
            int vstupYear = readValidInt(scanner, "Введіть рік вступу: ", 1900, 2026);
            Form form = null;
            int formSwitch = readValidInt(scanner, "Оберіть форму студента (1=BUDGET, 2=CONTRACT): ", 1, 2);
            switch (formSwitch) {
                case 1:
                    form = BUDGET;
                    break;
                case 2:
                    form = CONTRACT;
                    break;
                default:
                    break;
            }
            State state = null;
            int stateSwitch = readValidInt(scanner, "Оберіть стан студента (1=STUDYING, 2=ACADEMICLEAVE, 3=EXPELLED): ", 1, 3);
            switch (stateSwitch) {
                case 1:
                    state = STUDYING;
                    break;
                case 2:
                    state = ACADEMICLEAVE;
                    break;
                case 3:
                    state = EXPELLED;
                    break;
                default:
                    break;
            }
            Department department = readValidDepartment(scanner, university);
            Student newStudent = new Student(id, surname, name, fatherName, birthDate, email, number, department, course, group, vstupYear, form, state);
            department.getStudents().add(newStudent);
            System.out.println("Створено студента:" + newStudent);
            logger.info("Створено студента: {}", newStudent);
        }
    }

    public static void change(University university){
        Scanner scanner = new Scanner(System.in);
        boolean changeStudent = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати студента, введіть 0 якщо ні: ");
        if (changeStudent) {
            Student student = readValidStudent(scanner, university);
            logger.info("Cтудент до редагування: {}", student);
            boolean changeSurname = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати прізвище студента, введіть 0 якщо ні: ");
            if (changeSurname) student.setSurname(readValidString(scanner, "Введіть прізвище: "));
            boolean changeName = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати ім'я студента, введіть 0 якщо ні: ");
            if (changeName) student.setName(readValidString(scanner, "Введіть ім'я: "));
            boolean changeFatherName = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати по-батькові студента, введіть 0 якщо ні: ");
            if (changeFatherName) student.setFatherName(readValidString(scanner, "Введіть по-батькові: "));
            boolean changeBirthDate = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати дату народження студента, введіть 0 якщо ні: ");
            if (changeBirthDate) {
                int birthYear = readValidInt(scanner, "Введіть рік народження: ", 1900, 2026);
                int birthMonth = readValidInt(scanner, "Введіть місяць народження: ", 1, 12);
                int birthDay = readValidInt(scanner, "Введіть день народження: ", 1, 31);
                student.setBirthDate(LocalDate.of(birthYear, birthMonth, birthDay));
            }
            boolean changeEmail = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати пошту студента, введіть 0 якщо ні: ");
            if (changeEmail) student.setEmail(readValidString(scanner, "Введіть пошту: "));
            boolean changeNumber = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати номер студента, введіть 0 якщо ні: ");
            if (changeNumber) student.setNumber(readValidInt(scanner, "Введіть номер: ", 1, 10000000));
            boolean changeCourse = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати курс студента, введіть 0 якщо ні: ");
            if (changeCourse) student.setCourse(readValidInt(scanner, "Введіть курс: ", 1, 6));
            boolean changeGroup = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати групу студента, введіть 0 якщо ні: ");
            if (changeGroup) student.setGroup(readValidInt(scanner, "Введіть групу: ", 1, 6));
            boolean changeVstupYear = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати рік вступу студента, введіть 0 якщо ні: ");
            if (changeVstupYear) student.setVstupYear(readValidInt(scanner, "Введіть рік вступу: ", 1900, 2026));
            boolean changeForm = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати форму навчання студента, введіть 0 якщо ні: ");
            if (changeForm){
                Form form = null;
                int formSwitch = readValidInt(scanner, "Оберіть форму студента (1=BUDGET, 2=CONTRACT): ", 1, 2);
                switch (formSwitch) {
                    case 1:
                        form = BUDGET;
                        break;
                    case 2:
                        form = CONTRACT;
                        break;
                    default:
                        break;
                }
                student.setForm(form);
            }
            boolean changeState = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати стан студента, введіть 0 якщо ні: ");
            if(changeState) {
                State state = null;
                int stateSwitch = readValidInt(scanner, "Оберіть стан студента (1=STUDYING, 2=ACADEMICLEAVE, 3=EXPELLED): ", 1, 3);
                switch (stateSwitch) {
                    case 1:
                        state = STUDYING;
                        break;
                    case 2:
                        state = ACADEMICLEAVE;
                        break;
                    case 3:
                        state = EXPELLED;
                        break;
                    default:
                        break;
                }
                student.setState(state);
            }
            boolean changeDepartment = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати кафедру студента, введіть 0 якщо ні: ");
            if (changeDepartment) {
                Department oldDepartment = student.getDepartment();
                oldDepartment.getStudents().remove(student);

                Department newDepartment = readValidDepartment(scanner, university);
                student.setDepartment(newDepartment);
                newDepartment.getStudents().add(student);
            }
            logger.info("Відредагований студент: {}", student);
        }

    }
    public static void remove(University university){
        Scanner scanner = new Scanner(System.in);
        boolean removeStudent = readValidConfirmation(scanner, "Введіть 1 якщо хочете видалити студента, введіть 0 якщо ні: ");
        if(removeStudent) {
            Student student = readValidStudent(scanner, university);
            Department oldDepartment = student.getDepartment();
            oldDepartment.getStudents().remove(student);
            logger.info("Видалено студента: {}", student);
        }
    }
}
