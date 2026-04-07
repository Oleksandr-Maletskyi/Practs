package Rep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class Faculty {
    private long id;
    private String longName;
    private String shortName;
    private Teacher decan;
    private String email;
    private int phoneNumber;
    @ToString.Exclude
    private List<Department> departments = new ArrayList<>();

    public Faculty(long id, String longName, String shortName, Teacher decan, String email, int phoneNumber) {
        this.id = id;
        this.longName = longName;
        this.shortName = shortName;
        this.decan = decan;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void addDepartment(Department department){
        departments.add(department);
    }
}
