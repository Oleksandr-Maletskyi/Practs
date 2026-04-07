package Rep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor

public class Student extends Person{
    private long zalikovaId;
    private int course;
    private int group;
    private LocalDate vstupDate;
    private Form form;
    private State state;

    public Student(long id, String surname, String name, String fathername, LocalDate birthdate, String email, int number, long zalikovaId, int course, int group, LocalDate vstupDate, Form form, State state) {
        super(id, surname, name, fathername, birthdate, email, number);
        this.zalikovaId = zalikovaId;
        this.course = course;
        this.group = group;
        this.vstupDate = vstupDate;
        this.form = form;
        this.state = state;
    }
}
