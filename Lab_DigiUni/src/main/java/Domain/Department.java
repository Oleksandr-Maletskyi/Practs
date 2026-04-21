package Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

    public class Department implements Serializable {
    private long id;
    private String name;
    private Faculty faculty;
    private Teacher zaviduvach;
    private int korpus;
    private int kabinet;

    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public Department(long id, String name, Faculty faculty, int korpus, int kabinet) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.korpus = korpus;
        this.kabinet = kabinet;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty=" + faculty +
                ", zaviduvach=" + zaviduvach +
                ", korpus=" + korpus +
                ", kabinet=" + kabinet +
                '}';
    }
}
