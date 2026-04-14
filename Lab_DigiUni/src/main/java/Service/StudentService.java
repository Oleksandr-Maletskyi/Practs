package Repository;

import Domain.Department;
import Domain.Form;
import Domain.State;
import Domain.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class StudentLogic {
    public static void createStudent(String surname, String name, String fatherName, LocalDate birthDate, String email, int number, int course, int group, LocalDate vstupDate, Form form, State state, Department department){

        Student newStudent = new Student(surname, name, fatherName, birthDate, email, number, course, group, vstupDate, form, state);

        department.addStudent(newStudent);

    }
}
