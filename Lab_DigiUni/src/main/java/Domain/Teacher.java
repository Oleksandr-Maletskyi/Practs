package Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public final class Teacher extends Person implements Serializable {

    private String posada;
    private String stupin;
    private String zvanna;
    private LocalDate employmentDate;
    private int stavka;
    public int getExperience() {
        return Period.between(employmentDate, LocalDate.now()).getYears();
    }

    public Teacher(long id, String surname, String name, String fatherName, LocalDate birthDate, String email, int number, Department department, String posada, String stupin, String zvanna, LocalDate employmentDate, int stavka) {
        super(id, surname, name, fatherName, birthDate, email, number, department);
        this.posada = posada;
        this.stupin = stupin;
        this.zvanna = zvanna;
        this.employmentDate = employmentDate;
        this.stavka = stavka;
    }

}
