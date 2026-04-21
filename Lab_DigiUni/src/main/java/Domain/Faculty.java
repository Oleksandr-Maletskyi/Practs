package Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class Faculty implements Serializable {
    private long id;
    private String longName;
    private String shortName;
    private Teacher decan;
    private String email;
    private int number;
    private List<Department> departments = new ArrayList<>();

    public Faculty(long id, String longName, String shortName, String email, int number) {
        this.id = id;
        this.longName = longName;
        this.shortName = shortName;
        this.email = email;
        this.number = number;
    }


    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", longName='" + longName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", decan=" + decan +
                ", email='" + email + '\'' +
                ", phoneNumber=" + number +
                '}';
    }
}
