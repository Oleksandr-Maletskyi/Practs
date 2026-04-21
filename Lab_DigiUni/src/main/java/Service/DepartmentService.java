package Service;

import Domain.*;
import Exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import static Repository.Validator.*;

public class DepartmentService implements Service{
    private static final Logger logger = LogManager.getLogger();
    public static void create(University university){
        Scanner scanner = new Scanner(System.in);
        boolean createDepartment = readValidConfirmation(scanner, "Введіть 1 якщо хочете створити кафедру, введіть 0 якщо ні: ");
        if (createDepartment) {
            long id = university.getNextDepartmentId();
            String name = readValidString(scanner, "Введіть назву кафедри: ");
            int korpus = readValidInt(scanner, "Введіть корпус: ", 1, 12);
            int kabinet = readValidInt(scanner, "Введіть кабінет: ", 100, 500);

            Faculty faculty = readValidFaculty(scanner, university);
            Department newDepartment = new Department(id, name, faculty, korpus, kabinet);
            faculty.getDepartments().add(newDepartment);
            System.out.println("Створено кафедру:" + newDepartment);
            logger.info("Створено кафедру: {}", newDepartment);
        }
    }
    public static void change(University university){
        Scanner scanner = new Scanner(System.in);
        boolean changeDepartment = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати кафедру, введіть 0 якщо ні: ");
        if (changeDepartment) {
            Department department = readValidDepartment(scanner, university);
            logger.info("Кафедра до редагування: {}", department);
            boolean changeName = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати назву кафедри, введіть 0 якщо ні: ");
            if (changeName) department.setName(readValidString(scanner, "Введіть назву кафедри: "));
            boolean changeLocation = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати розташування кафедри, введіть 0 якщо ні: ");
            if (changeLocation) {
                department.setKorpus(readValidInt(scanner, "Введіть корпус: ", 1, 12));;
                department.setKabinet(readValidInt(scanner, "Введіть кабінет: ", 100, 500));
            }
            boolean changeFaculty = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати факультет кафедри, введіть 0 якщо ні: ");
            if (changeFaculty) {
                Faculty oldFaculty = department.getFaculty();
                oldFaculty.getDepartments().remove(department);

                Faculty newFaculty = readValidFaculty(scanner, university);
                department.setFaculty(newFaculty);
                newFaculty.getDepartments().add(department);
            }
            boolean changeZaviduvach = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати завідувача кафедри, введіть 0 якщо ні: ");
            if (changeZaviduvach){
                while(true) {
                    try {
                        Teacher zaviduvach = readValidTeacher(scanner, university);
                        if (zaviduvach.getDepartment().equals(department)) {
                            department.setZaviduvach(zaviduvach);
                            break;
                        } else {
                            logger.warn("Спроба встановити завідувачем викладача хибної кафедри: {}", zaviduvach);
                            throw new TeacherDontHavePermissionException("Завідувачем кафедри може стати лише викладач цієї кафедри, спробуйте ще раз");
                        }
                    }
                    catch (TeacherDontHavePermissionException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
            logger.info("Відредагована кафедра: {}", department);
        }
    }
    public static void remove(University university){
        Scanner scanner = new Scanner(System.in);
        boolean removeDepartment = readValidConfirmation(scanner, "Введіть 1 якщо хочете видалити кафедру, введіть 0 якщо ні: ");
        if(removeDepartment) {
            Department department = readValidDepartment(scanner, university);
            Faculty oldFaculty = department.getFaculty();
            oldFaculty.getDepartments().remove(department);
            logger.info("Видалено кафедру: {}", department);
        }
    }
}
