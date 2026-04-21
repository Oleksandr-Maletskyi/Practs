package UI;

import Domain.University;
import Service.DepartmentService;
import Service.FacultyService;

import java.util.Scanner;

import static Repository.Validator.readValidInt;

public class DepartmentServiceUI {
    public static void UI (University university) {
        Scanner scanner = new Scanner(System.in);
        int choice = readValidInt(scanner, "1. Створити кафедру \n2. Редагувати/Оновити дані кафедри \n3. Видалити кафедру \n0. Повернутися в меню \nОберіть дію над кафедрою вводячи відповідне значення в консоль: ", 0, 3);
        switch (choice) {
            case 1:
                DepartmentService.create(university);
                break;
            case 2:
                DepartmentService.change(university);
                break;
            case 3:
                DepartmentService.remove(university);
                break;
            default:
                break;
        }
    }
}
