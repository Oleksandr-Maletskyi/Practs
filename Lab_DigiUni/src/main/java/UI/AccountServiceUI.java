package UI;

import Domain.University;
import Service.AccountService;
import Service.StudentService;

import java.util.Scanner;

import static Repository.Validator.readValidInt;

public class AccountServiceUI {
    public static void UI (University university) {
        Scanner scanner = new Scanner(System.in);
        int choice = readValidInt(scanner, "1. Створити акаунт \n2. Редагувати/Оновити дані акаунта\n3. Видалити акаунт \n0. Повернутися в меню \nОберіть дію над акаунтом вводячи відповідне значення в консоль: ", 0, 3);
        switch (choice) {
            case 1:
                AccountService.create(university);
                break;
            case 2:
                AccountService.change(university);
                break;
            case 3:
                AccountService.remove(university);
                break;
            default:
                break;
        }
    }
}
