package Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public final class Student extends Person implements Serializable {

    private long zalikovaId;
    private int course;
    private int group;
    private int vstupYear;
    private LocalDate vstupDate;
    private Form form;
    private State state;

    public Student(long id, String surname, String name, String fatherName, LocalDate birthDate, String email, int number, Department department, int course, int group, int vstupYear, Form form, State state) {
        super(id, surname, name, fatherName, birthDate, email, number, department);
        this.course = course;
        this.group = group;
        this.vstupYear = vstupYear;
        this.form = form;
        this.state = state;
        this.zalikovaId = id;
        this.vstupDate = LocalDate.of(vstupYear, 9, 1);
    }
}
