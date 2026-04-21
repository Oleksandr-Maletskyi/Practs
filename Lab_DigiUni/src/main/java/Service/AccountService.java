package Service;

import Domain.*;
import java.util.Scanner;
import Exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static Domain.Role.*;
import static Repository.Validator.*;

public class AccountService {
    private static final Logger logger = LogManager.getLogger();
    public static void create(University university){
        Scanner scanner = new Scanner(System.in);
        boolean createAccount = readValidConfirmation(scanner, "Введіть 1 якщо хочете створити акаунт, введіть 0 якщо ні: ");
        if (createAccount) {
            String login;
            while (true) {
                try {
                    login = readValidString(scanner, "Введіть логін: ");

                    if (university.getAccountsMap().containsKey(login)) {
                        logger.warn("Невдала спроба акаунт з логіном: {}", login);
                        throw new EntityDuplicateException("Помилка: Логін '" + login + "' вже зайнятий! Придумайте інший.");
                    }
                    break;

                } catch (EntityDuplicateException e) {
                    System.out.println(e.getMessage());
                }
            }
            String password = readValidString(scanner, "Введіть пароль: ");
            Role role = null;
            int roleSwitch = readValidInt(scanner, "Оберіть роль акаунта (1=USER, 2=MANAGER, 3=ADMIN): ", 1, 3);
            switch (roleSwitch) {
                case 1:
                    role = USER;
                    break;
                case 2:
                    role = MANAGER;
                    break;
                case 3:
                    role = ADMIN;
                    break;
                default:
                    break;
            }
            Account newAccount = new Account(login, password, role);
            university.getAccountsMap().put(newAccount.getLogin(), newAccount);
            logger.info("Створено акаунт: {}", newAccount);
        }
    }
    public static void change(University university){
        Scanner scanner = new Scanner(System.in);
        boolean changeAccount = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати акаунт, введіть 0 якщо ні: ");
        if (changeAccount) {
            Account account = readValidAccountByLogin(scanner, university);
            logger.info("Акаунт до редагування: {}", account);
            boolean changeLogin = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати логін акаунта, введіть 0 якщо ні: ");
            if (changeLogin) {
                String oldLogin = account.getLogin();
                String newLogin;
                while (true) {
                    try {
                        newLogin = readValidString(scanner, "Введіть новий логін: ");
                        if(newLogin.equals(oldLogin)) break;
                        else if (university.getAccountsMap().containsKey(newLogin)) {
                            logger.warn("Невдала спроба змінити логін акаунта: {}", account);
                            throw new EntityDuplicateException("Помилка: Цей логін вже зайнятий!");
                        }
                        break;
                    } catch (EntityDuplicateException e) {
                        System.out.println(e.getMessage());
                    }
                }

                university.getAccountsMap().remove(oldLogin);
                account.setLogin(newLogin);
                university.getAccountsMap().put(newLogin, account);
            }
            boolean changePassword = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати пароль акаунта, введіть 0 якщо ні: ");
            if (changePassword) account.setPassword(readValidString(scanner, "Введіть пароль: "));
            boolean changeRole = readValidConfirmation(scanner, "Введіть 1 якщо хочете редагувати роль акаунта, введіть 0 якщо ні: ");
            if (changeRole){
                Role role = null;
                int roleSwitch = readValidInt(scanner, "Оберіть роль акаунта (1=USER, 2=MANAGER, 3=ADMIN): ", 1, 3);
                switch (roleSwitch) {
                    case 1:
                        role = USER;
                        break;
                    case 2:
                        role = MANAGER;
                        break;
                    case 3:
                        role = ADMIN;
                        break;
                    default:
                        break;
                }
                account.setRole(role);
            }
            logger.info("Відредагований акаунт: {}", account);
        }
    }
    public static void remove(University university){
        Scanner scanner = new Scanner(System.in);
        boolean removeAccount = readValidConfirmation(scanner, "Введіть 1 якщо хочете видалити акаунта, введіть 0 якщо ні: ");
        if(removeAccount) {
            Account account = readValidAccountByLogin(scanner, university);
            university.getAccountsMap().remove(account.getLogin());
            logger.info("Видалено акаунт: {}", account);
        }
    }
}
