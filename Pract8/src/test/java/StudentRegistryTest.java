import Assignment3.Student;
import Assignment3.StudentRegistry;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentRegistryTest {

    @Test
    void testRemoveByIdClearsAllData() {
        StudentRegistry registry = new StudentRegistry();
        Student s1 = new Student("101", "Олександр");
        String email = "o.maletskyi@ukma.edu.ua";

        registry.addStudent(s1, email);
        registry.removeById("101");

        assertNull(registry.findById("101"), "Student should be removed from Map");
        assertFalse(registry.containsEmail(email), "Email should be removed from Set");
    }

    @Test
    void testEmailCanBeReusedAfterRemoval() {
        StudentRegistry registry = new StudentRegistry();
        String email = "duplicate@test.com";

        registry.addStudent(new Student("1", "User1"), email);
        registry.removeById("1");

        boolean addedAgain = registry.addStudent(new Student("2", "User2"), email);

        assertTrue(addedAgain, "Email should be available for reuse after removal");
    }
}
