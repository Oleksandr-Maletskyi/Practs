package Rep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

    public class Department {
    private long id;
    private String name;
    private Faculty faculty;
    private Teacher zaviduvach;
    private int korpus;
    private int kabinet;

    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public Department(long id, String name, Faculty faculty, Teacher zaviduvach, int korpus, int kabinet) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.zaviduvach = zaviduvach;
        this.korpus = korpus;
        this.kabinet = kabinet;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

}
