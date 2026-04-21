package UI;

import Domain.University;
import Service.FacultyService;
import Service.StudentService;

import java.util.Scanner;

import static Repository.Validator.readValidInt;

public class FacultyServiceUI {
    public static void UI (University university) {
        Scanner scanner = new Scanner(System.in);
        int choice = readValidInt(scanner, "1. Створити факультет \n2. Редагувати/Оновити дані факультету \n3. Видалити факультет \n0. Повернутися в меню \nОберіть дію над факультетом вводячи відповідне значення в консоль: ", 0, 3);
        switch (choice) {
            case 1:
                FacultyService.create(university);
                break;
            case 2:
                FacultyService.change(university);
                break;
            case 3:
                FacultyService.remove(university);
                break;
            default:
                break;
        }
    }
}
