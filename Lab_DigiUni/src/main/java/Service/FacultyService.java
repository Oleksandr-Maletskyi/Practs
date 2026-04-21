package Service;

import Domain.Faculty;
import Domain.Teacher;
import Domain.University;
import Exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static Repository.Validator.*;

public class FacultyService implements Service{
    private static final Logger logger = LogManager.getLogger();
    public static void create(University university){
        Scanner scanner = new Scanner(System.in);
        boolean createFaculty = readValidConfirmation(scanner, "Введіть 1 якщо хочете створити факультет, введіть 0 якщо ні: ");
        if (createFaculty) {
            long id = university.getNextFacultyId();
            String longName = readValidString(scanner, "Введіть повну назву факультету: ");
            String shortName = readValidString(scanner, "Введіть коротку назву факультету: ");
            String email = readValidString(scanner, "Введіть пошту: ");
            int number = readValidInt(scanner, "Введіть номер: ", 1, 10000000);

            Faculty newFaculty = new Faculty(id, longName, shortName, email, number);
            university.getFaculties().add(newFaculty);
            System.out.println("Створено факультет:" + newFaculty);
            logger.info("Cтворено факультет: {}", newFaculty);
        }
    }
    public static void change(University university){
        Scanner scanner = new Scanner(System.in);
        boolean changeFaculty = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати факультет, введіть 0 якщо ні: ");
        if (changeFaculty) {
            Faculty faculty = readValidFaculty(scanner, university);
            logger.info("Факультет до редагування: {}", faculty);
            boolean changeLongName = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати повну назву факультету, введіть 0 якщо ні: ");
            if (changeLongName) faculty.setLongName(readValidString(scanner, "Введіть повну назву факультету: "));
            boolean changeShortName = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати коротку назву факультету, введіть 0 якщо ні: ");
            if (changeShortName) faculty.setShortName(readValidString(scanner, "Введіть коротку назву факультету: "));
            boolean changeEmail = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати пошту факультету, введіть 0 якщо ні: ");
            if (changeEmail) faculty.setEmail(readValidString(scanner, "Введіть пошту: "));
            boolean changeNumber = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати номер факультету, введіть 0 якщо ні: ");
            if (changeNumber) faculty.setNumber(readValidInt(scanner, "Введіть номер: ", 1, 10000000));

            boolean changeDecan = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати декана факультету, введіть 0 якщо ні: ");
            if (changeDecan) {
                while (true) {
                    try {
                        Teacher decan = readValidTeacher(scanner, university);
                        if (decan.getDepartment().getFaculty().equals(faculty)) {
                            faculty.setDecan(decan);
                            break;
                        } else {
                            logger.warn("Спроба встановити деканом викладача хибного факультету: {}", decan);
                            throw new TeacherDontHavePermissionException("Деканом факультету може стати лише викладач цього факультету, спробуйте ще раз");
                        }
                    }
                    catch(TeacherDontHavePermissionException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
            logger.info("Відредагований факультет: {}", faculty);
        }
    }
    public static void remove(University university){
        Scanner scanner = new Scanner(System.in);
        boolean removeFaculty = readValidConfirmation(scanner, "Введіть 1 якщо хочете видалити факультету, введіть 0 якщо ні: ");
        if(removeFaculty) {
            Faculty faculty = readValidFaculty(scanner, university);
            university.getFaculties().remove(faculty);
            logger.info("Видалено факультет: {}", faculty);
        }
    }
}
