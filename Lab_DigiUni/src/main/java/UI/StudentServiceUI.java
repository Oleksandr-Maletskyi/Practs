package UI;

import Domain.University;
import Service.StudentService;
import java.util.Scanner;
import static Repository.Validator.*;

public class StudentServiceUI {
    public static void UI (University university) {
        Scanner scanner = new Scanner(System.in);
        int choice = readValidInt(scanner, "1. Створити студента \n2. Редагувати/Оновити дані студента \n3. Видалити студента \n0. Повернутися в меню \nОберіть дію над студентом вводячи відповідне значення в консоль: ", 0, 3);
        switch (choice) {
            case 1:
                StudentService.create(university);
                break;
            case 2:
                StudentService.change(university);
                break;
            case 3:
                StudentService.remove(university);
                break;
            default:
                break;
        }
    }
}
