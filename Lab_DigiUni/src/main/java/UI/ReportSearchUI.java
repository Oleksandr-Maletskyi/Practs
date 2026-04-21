package UI;

import Domain.Role;
import Domain.University;
import Service.Report;
import Service.Search;

import java.util.Scanner;

import static Domain.Role.ADMIN;
import static Repository.Validator.readValidInt;

public class ReportSearchUI {
    public static void UI (University university, Role role) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        if(role.equals(ADMIN)) choice = readValidInt(scanner, "1. Знайти студента за ПІБ. \n2. Знайти викладача за ПІБ. \n3. Знайти студента за курсом. \n4. Знайти студента за групою. \n5. Студенти відсортовані за курсом. \n6. Студенти відсортовані за алфавітом. \n7. Викладачі відсортовані за алфавітом. \n8. Студенти кафедри відсортовані за курсом. \n9. Студенти кафедри відсортовані за алфавітом. \n10. Студенти кафедри вказаного курсу відсортовані за курсом. \n11. Студенти кафедри вказаного курсу. \n12. Факультети і їх кафедри. \n13. Список акаунтів. \n0. Повернутися в меню \nОберіть дію над факультетом вводячи відповідне значення в консоль: ", 0, 13);
        else choice = readValidInt(scanner, "1. Знайти студента за ПІБ. \n2. Знайти викладача за ПІБ. \n3. Знайти студента за курсом. \n4. Знайти студента за групою. \n5. Студенти відсортовані за курсом. \n6. Студенти відсортовані за алфавітом. \n7. Викладачі відсортовані за алфавітом. \n8. Студенти кафедри відсортовані за курсом. \n9. Студенти кафедри відсортовані за алфавітом. \n10. Студенти кафедри вказаного курсу відсортовані за курсом. \n11. Студенти кафедри вказаного курсу. \n12. Факультети і їх кафедри. \n0. Повернутися в меню \nОберіть дію над факультетом вводячи відповідне значення в консоль: ", 0, 12);
        switch (choice) {
            case 1:
                Search.findStudentsByPib(university).forEach(System.out::println);
                break;
            case 2:
                Search.findTeachersByPib(university).forEach(System.out::println);
                break;
            case 3:
                Search.findStudentsByCourse(university).forEach(System.out::println);
                break;
            case 4:
                Search.findStudentsByGroup(university).forEach(System.out::println);
                break;
            case 5:
                Report.printStudentsSortedByCourse(university);
                break;
            case 6:
                Report.printStudentsSortedByAlphabet(university);
                break;
            case 7:
                Report.printTeachersSortedByAlphabet(university);
                break;
            case 8:
                Report.printDepartmentStudentsByCourse(university);
                break;
            case 9:
                Report.printDepartmentStudentsByAlphabet(university);
                break;
            case 10:
                Report.printDepartmentStudentsOfCourseByAlphabet(university);
                break;
            case 11:
                Report.printDepartmentStudentsOfCourse(university);
                break;
            case 12:
                Report.printFacultiesAndDepartments(university);
                break;
            case 13:
                Report.printAllAccounts(university);
                break;
            default:
                break;
        }
    }
}
