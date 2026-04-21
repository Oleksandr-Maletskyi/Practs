package Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
public abstract sealed class Person implements Serializable permits Student, Teacher {
    private long id;
    private String surname;
    private String name;
    private String fatherName;
    private LocalDate birthDate;
    private String email;
    private int number;
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    private Department  department;

    public Person(long id, String surname, String name, String fatherName, LocalDate birthDate, String email, int number, Department  department) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.email = email;
        this.number = number;
        this.department  = department;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", number=" + number +
                ", department=" + department.getName() +
                '}';
    }
}
