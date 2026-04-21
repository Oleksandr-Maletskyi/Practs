package Repository;

import Domain.*;
import Exception.*;
import java.util.Scanner;

public class Validator {
    public static String readValidString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine().trim();

                if (!input.isEmpty()) {
                    return input;
                } else throw new NullArgumentException("Помилка: поле не може бути порожнім! Спробуйте ще раз.");
            } catch (NullArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static int readValidInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());

                if (value >= min && value <= max) {
                    return value;
                } else throw new IllegalArgumentDiapasonException("Помилка: число має бути від " + min + " до " + max + ".");

            } catch (NumberFormatException e) {
                System.out.println("Помилка: це не схоже на ціле число! Спробуйте ще раз.");
            } catch (IllegalArgumentDiapasonException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean readValidConfirmation(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());

                if (value == 1) {
                    return true;
                } else if (value == 0) {
                    return false;
                } else throw new IllegalArgumentDiapasonException("Помилка: число має бути 1 чи 0.");
            } catch (NumberFormatException e) {
                System.out.println("Помилка: це не схоже на ціле число! Спробуйте ще раз.");
            } catch (IllegalArgumentDiapasonException e){
            System.out.println(e.getMessage());
        }
        }
    }

    public static Student readValidStudent(Scanner scanner, University university) {
        while (true) {
            try {
                long inputId = readValidInt(scanner, "Введіть ID існуючого студента: ", 1, 10000);

                for (Faculty faculty : university.getFaculties()) {
                    for (Department department : faculty.getDepartments()) {
                        for (Student student : department.getStudents()) {
                            if (student.getId() == inputId) {
                                System.out.println("Знайдено студента: " + student.toString());
                                return student;
                            }
                        }
                    }
                }
                throw new EntityNotFoundException("Помилка: Студента з таким ID не існує в університеті. Спробуйте ще раз.");
            }
            catch (EntityNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Teacher readValidTeacher(Scanner scanner, University university) {
        while (true) {
            try {
                long inputId = readValidInt(scanner, "Введіть ID існуючого викладача: ", 1, 10000);

                for (Faculty faculty : university.getFaculties()) {
                    for (Department department : faculty.getDepartments()) {
                        for (Teacher teacher : department.getTeachers()) {
                            if (teacher.getId() == inputId) {
                                System.out.println("Знайдено викладача: " + teacher.toString());
                                return teacher;
                            }
                        }
                    }
                }
                throw new EntityNotFoundException("Помилка: Викладача з таким ID не існує в університеті. Спробуйте ще раз.");
            }
            catch (EntityNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Department readValidDepartment(Scanner scanner, University university) {
        while (true) {
            try {
                long inputId = readValidInt(scanner, "Введіть ID існуючої кафедри: ", 1, 1000);
                for (Faculty faculty : university.getFaculties()) {
                    for (Department department : faculty.getDepartments()) {
                        if (department.getId() == inputId) {
                            System.out.println("Знайдено кафедру: " + department.getName());
                            return department;
                        }
                    }
                }
                throw new EntityNotFoundException("Помилка: Кафедри з таким ID не існує в університеті. Спробуйте ще раз.");
            }
            catch (EntityNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Faculty readValidFaculty(Scanner scanner, University university) {
        while (true) {
            try {
                long inputId = readValidInt(scanner, "Введіть ID існуючого факультету: ", 1, 1000);

                for (Faculty faculty : university.getFaculties()) {
                    if (faculty.getId() == inputId) {
                        System.out.println("Знайдено факультет: " + faculty.getLongName());
                        return faculty;
                    }
                }
                throw new EntityNotFoundException("Помилка: Факультету з таким ID не існує в університеті. Спробуйте ще раз.");
            }
            catch (EntityNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Account readValidAccount(Scanner scanner, University university) {
        while (true) {
            try {
                String inputLogin = readValidString(scanner, "Введіть логін: ");
                String inputPassword = readValidString(scanner, "Введіть пароль: ");

                Account account = university.getAccountsMap().get(inputLogin);
                if (account != null && account.getPassword().equals(inputPassword)) {
                    System.out.println("Успішний вхід. Ваш рівень доступу: " + account.getRole());
                    return account;
                }

                throw new EntityNotFoundException("Помилка: Акаунта з такими даними не існує в університеті. Спробуйте ще раз.");
            }
            catch (EntityNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Account readValidAccountByLogin(Scanner scanner, University university) {
        while (true) {
            try {
                String inputLogin = readValidString(scanner, "Введіть логін: ");

                Account account = university.getAccountsMap().get(inputLogin);
                if (account != null){
                    System.out.println("Акаунт знайдено.");
                    return account;
                }

                throw new EntityNotFoundException("Помилка: Акаунта з такими даними не існує в університеті. Спробуйте ще раз.");
            }
            catch (EntityNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
