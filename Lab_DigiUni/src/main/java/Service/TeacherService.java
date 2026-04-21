package Service;

import Domain.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Scanner;

import static Repository.Validator.*;

public class TeacherService implements Service {
    private static final Logger logger = LogManager.getLogger();
    public static void create(University university){
        Scanner scanner = new Scanner(System.in);
        boolean createTeacher = readValidConfirmation(scanner, "Введіть 1 якщо хочете створити викладача, введіть 0 якщо ні: ");
        if (createTeacher) {
            long id = university.getNextTeacherId();
            String surname = readValidString(scanner, "Введіть прізвище: ");
            String name = readValidString(scanner, "Введіть ім'я: ");
            String fatherName = readValidString(scanner, "Введіть по-батькові: ");
            int birthYear = readValidInt(scanner, "Введіть рік народження: ", 1900, 2026);
            int birthMonth = readValidInt(scanner, "Введіть місяць народження: ", 1, 12);
            int birthDay = readValidInt(scanner, "Введіть день народження: ", 1, 31);
            LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
            String email = readValidString(scanner, "Введіть пошту: ");
            int number = readValidInt(scanner, "Введіть номер: ", 1, 10000000);
            String posada = readValidString(scanner, "Введіть посаду: ");
            String stupin = readValidString(scanner, "Введіть ступінь: ");
            String zvanna = readValidString(scanner, "Введіть звання: ");
            int employmentYear = readValidInt(scanner, "Введіть рік працевлаштування: ", 1900, 2026);
            int employmentMonth = readValidInt(scanner, "Введіть місяць працевлаштування: ", 1, 12);
            int employmentDay = readValidInt(scanner, "Введіть день працевлаштування: ", 1, 31);
            LocalDate employmentDate = LocalDate.of(employmentYear, employmentMonth, employmentDay);
            int stavka = readValidInt(scanner, "Введіть кількість тижневого навантаження: ", 0, 120);
            Department department = readValidDepartment(scanner, university);
            Teacher newTeacher = new Teacher(id, surname, name, fatherName, birthDate, email, number, department, posada, stupin, zvanna, employmentDate, stavka);
            department.getTeachers().add(newTeacher);
            System.out.println("Створено викладача:" + newTeacher);
            logger.info("Створено викладача: {}", newTeacher);
        }
    }

    public static void change(University university){
        Scanner scanner = new Scanner(System.in);
        boolean changeTeacher = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати викладача, введіть 0 якщо ні: ");
        if (changeTeacher) {
            Teacher teacher = readValidTeacher(scanner, university);
            logger.info("Викладач до редагування: {}", teacher);
            boolean changeSurname = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати прізвище викладача, введіть 0 якщо ні: ");
            if (changeSurname) teacher.setSurname(readValidString(scanner, "Введіть прізвище: "));
            boolean changeName = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати ім'я викладача, введіть 0 якщо ні: ");
            if (changeName) teacher.setName(readValidString(scanner, "Введіть ім'я: "));
            boolean changeFatherName = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати по-батькові викладача, введіть 0 якщо ні: ");
            if (changeFatherName) teacher.setFatherName(readValidString(scanner, "Введіть по-батькові: "));
            boolean changeBirthDate = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати дату народження викладача, введіть 0 якщо ні: ");
            if (changeBirthDate) {
                int birthYear = readValidInt(scanner, "Введіть рік народження: ", 1900, 2026);
                int birthMonth = readValidInt(scanner, "Введіть місяць народження: ", 1, 12);
                int birthDay = readValidInt(scanner, "Введіть день народження: ", 1, 31);
                teacher.setBirthDate(LocalDate.of(birthYear, birthMonth, birthDay));
            }
            boolean changeEmail = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати пошту викладача, введіть 0 якщо ні: ");
            if (changeEmail) teacher.setEmail(readValidString(scanner, "Введіть пошту: "));
            boolean changeNumber = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати номер викладача, введіть 0 якщо ні: ");
            if (changeNumber) teacher.setNumber(readValidInt(scanner, "Введіть номер: ", 1, 10000000));
            boolean changePosada = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати посаду викладача, введіть 0 якщо ні: ");
            if (changePosada) teacher.setPosada(readValidString(scanner, "Введіть нову посаду: "));
            boolean changeStupin = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати науковий ступінь викладача, введіть 0 якщо ні: ");
            if (changeStupin) teacher.setStupin(readValidString(scanner, "Введіть новий науковий ступінь: "));
            boolean changeZvanna = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати вчене звання викладача, введіть 0 якщо ні: ");
            if (changeZvanna) teacher.setZvanna(readValidString(scanner, "Введіть нове вчене звання: "));
            boolean changeEmploymentDate = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати дату працевлаштування викладача, введіть 0 якщо ні: ");
            if (changeEmploymentDate) {
                int employmentYear = readValidInt(scanner, "Введіть рік працевлаштування: ", 1900, 2026);
                int employmentMonth = readValidInt(scanner, "Введіть місяць працевлаштування: ", 1, 12);
                int employmentDay = readValidInt(scanner, "Введіть день працевлаштування: ", 1, 31);
                teacher.setEmploymentDate(LocalDate.of(employmentYear, employmentMonth, employmentDay));
            }
            boolean changeStavka = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати тижневе навантаження викладача, введіть 0 якщо ні: ");
            if (changeStavka) teacher.setStavka(readValidInt(scanner, "Введіть тижневе навантаження: ", 0, 120));
            boolean changeDepartment = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати кафедру викладача, введіть 0 якщо ні: ");
            if (changeDepartment) {
                Department oldDepartment = teacher.getDepartment();
                oldDepartment.getTeachers().remove(teacher);

                Department newDepartment = readValidDepartment(scanner, university);
                teacher.setDepartment(newDepartment);
                newDepartment.getTeachers().add(teacher);
            }
            logger.info("Відредагований викладач: {}", teacher);
        }

    }
    public static void remove(University university){
        Scanner scanner = new Scanner(System.in);
        boolean removeTeacher = readValidConfirmation(scanner, "Введіть 1 якщо хочете видалити викладача, введіть 0 якщо ні: ");
        if(removeTeacher) {
            Teacher teacher = readValidTeacher(scanner, university);
            Department oldDepartment = teacher.getDepartment();
            oldDepartment.getTeachers().remove(teacher);
            logger.info("Видалено викладача: {}", teacher);
        }
    }
}
