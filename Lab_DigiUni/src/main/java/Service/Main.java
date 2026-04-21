package Service;

import Domain.*;
import Repository.DataLoader;
import Repository.FileStorage;
import UI.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static Domain.Role.*;
import static Repository.Validator.*;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    static void main() {
        Scanner scanner = new Scanner(System.in);
        University myUni = FileStorage.load();
        //University myUni = new DataLoader().myUni();

        while(true) {
            Account currentAccount = readValidAccount(scanner, myUni);
            logger.info("Авторизувався користувач: {}", currentAccount);
            System.out.println("DigiUni");
            while (true) {
                int choice = 0;
                if (currentAccount.getRole().equals(USER)) choice = readValidInt(scanner, "1. Звіти \n0. Повернутися в меню \nОберіть дію вводячи відповідне значення в консоль: ", 0, 1);
                else if (currentAccount.getRole().equals(MANAGER)) choice = readValidInt(scanner, "1. Звіти \n2. Дії над студентом \n3. Дії над викладачам  \n4. Дії над кафедрою \n5. Дії над факультетом \n6. Збереження університету \n0. Повернутися в меню \nОберіть дію вводячи відповідне значення в консоль: ", 0, 6);
                else if (currentAccount.getRole().equals(ADMIN)) choice = readValidInt(scanner, "1. Звіти \n2. Дії над студентом \n3. Дії над викладачам  \n4. Дії над кафедрою \n5. Дії над факультетом \n6. Збереження університету  \n7. Дії над акаунтами  \n0. Повернутися в меню \nОберіть дію вводячи відповідне значення в консоль: ", 0, 7);
                if (choice == 0){
                    logger.info("Закінчив роботу користувач: {}", currentAccount);
                    break;
                }
                switch (choice) {
                    case 1:
                        ReportSearchUI.UI(myUni, currentAccount.getRole());
                        break;
                    case 2:
                        StudentServiceUI.UI(myUni);
                        break;
                    case 3:
                        TeacherServiceUI.UI(myUni);
                        break;
                    case 4:
                        DepartmentServiceUI.UI(myUni);
                        break;
                    case 5:
                        FacultyServiceUI.UI(myUni);
                        break;
                    case 6:
                        FileStorage.save(myUni);
                        break;
                    case 7:
                        AccountServiceUI.UI(myUni);
                        break;
                    default:
                        break;
                }
            }
        }
    }
    //Дописати хоч даталоудер, ліпше ІО зробити звіти додати оптіонал, кастомні помилки, логування, тести і далі по списку.
    //Дописати логування для АкаунтСервіса warn, дописати логування для Репорт і Серч, зробити логування в файл, дописати антоації, серіалізацію і збереження також 20 тестів, використати рекорд чи сілд, дописати в звіти звіт з акаунтами логін пароль тільк для адміна.
}
