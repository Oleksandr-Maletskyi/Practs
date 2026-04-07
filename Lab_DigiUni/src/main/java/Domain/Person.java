package Rep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {
    private long id;
    private String surname;
    private String name;
    private String fathername;
    private LocalDate birthdate;
    private String email;
    private int number;
}
