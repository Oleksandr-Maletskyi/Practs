//Більше не використовується
package Repository;

import Domain.*;

import java.time.LocalDate;
import java.util.Scanner;

import static Domain.Form.BUDGET;
import static Domain.Role.*;
import static Domain.State.STUDYING;

public class DataLoader {
    public University myUni(){
        Scanner scanner = new Scanner(System.in);

        University myUni = new University("Могила", "НаУКМА", "Київ", "Борисоглібська");
        Faculty myFac = new Faculty(myUni.getNextFacultyId(), "Факультет інформатики", "ФІ", "fi@gmail.com", 6711111);
        Department myDep = new Department(myUni.getNextDepartmentId(), "Кафедра мережок", myFac, 1, 311);
        Department notMyDep = new Department(myUni.getNextDepartmentId(), "Кафедра математики", myFac, 1, 301);
        Teacher decan = new Teacher(myUni.getNextTeacherId(), "Глибовець", "Андрій", "Миколайович", LocalDate.of(1980, 5, 12), "glyb@ukma.edu", 123456, myDep, "Декан", "Доктор", "Професор", LocalDate.of(1980, 5, 12), 6);
        Student ya = new Student(myUni.getNextStudentId(), "Малецький", "Олександр", "Вікторович", LocalDate.of(2008, 9, 1), "o.maletskyi@ukma.edu", 1234567, myDep, 1, 5, 2025, BUDGET, STUDYING);
        Student neYa = new Student(myUni.getNextStudentId(), "Малецький", "Олександр", "Вікторович", LocalDate.of(2008, 9, 1), "o.maletskyi@ukma.edu", 1234567, myDep, 1, 5, 2025, BUDGET, STUDYING);

        myUni.getFaculties().add(myFac);

        myFac.getDepartments().add(myDep);
        myFac.getDepartments().add(notMyDep);

        myDep.getStudents().add(ya);
        myDep.getStudents().add(neYa);

        myFac.setDecan(decan);
        myDep.setZaviduvach(decan);


        Account myUserAccount = new Account("user", "user", USER);
        myUni.getAccountsMap().put(myUserAccount.getLogin(), myUserAccount);

        Account myManagerAccount = new Account("manager", "manager", MANAGER);
        myUni.getAccountsMap().put(myManagerAccount.getLogin(), myManagerAccount);

        Account myAdminAccount = new Account("admin", "admin", ADMIN);
        myUni.getAccountsMap().put(myAdminAccount.getLogin(), myAdminAccount);

        return myUni;
    }
}
