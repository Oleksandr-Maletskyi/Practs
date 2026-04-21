package UI;

import Domain.University;
import Service.StudentService;
import Service.TeacherService;

import java.util.Scanner;

import static Repository.Validator.readValidInt;

public class TeacherServiceUI {
    public static void UI (University university) {
        Scanner scanner = new Scanner(System.in);
        int choice = readValidInt(scanner, "1. Створити викладача \n2. Редагувати/Оновити дані викладача \n3. Видалити викладача \n0. Повернутися в меню \nОберіть дію над викладачем вводячи відповідне значення в консоль: ", 0, 3);
        switch (choice) {
            case 1:
                TeacherService.create(university);
                break;
            case 2:
                TeacherService.change(university);
                break;
            case 3:
                TeacherService.remove(university);
                break;
            default:
                break;
        }
    }
}
