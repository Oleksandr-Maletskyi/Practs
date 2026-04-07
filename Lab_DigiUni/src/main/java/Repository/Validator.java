package Repository;

import java.util.Scanner;

public class Logic {
    public int readValidInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());

                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Помилка: число має бути від " + min + " до " + max + ".");
                }

            } catch (NumberFormatException e) {
                System.out.println("Помилка: це не схоже на ціле число! Спробуйте ще раз.");
            }
        }
    }
}
