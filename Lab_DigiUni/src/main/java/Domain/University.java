package Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class University implements Serializable {
    private String longName;
    private String shortName;
    private String city;
    private String address;
    private List<Faculty> faculties = new ArrayList<>();
    private Map<String, Account> accountsMap = new HashMap<>();

    private long nextStudentId = 1;
    private long nextTeacherId = 1;

    private long nextFacultyId = 1;
    private long nextDepartmentId = 1;


    public long getNextStudentId() {
        return nextStudentId++;
    }

    public long getNextTeacherId() {
        return nextTeacherId++;
    }

    public long getNextFacultyId() {
        return nextFacultyId++;
    }

    public long getNextDepartmentId() {
        return nextDepartmentId++;
    }

    public University(String longName, String shortName, String city, String address) {
        this.longName = longName;
        this.shortName = shortName;
        this.city = city;
        this.address = address;
    }


    @Override
    public String toString() {
        return "University{" +
                "longName='" + longName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
