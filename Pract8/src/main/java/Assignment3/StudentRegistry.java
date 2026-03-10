package Assignment3;

import java.util.*;

public class StudentRegistry {
    private final List<Student> students = new ArrayList<>();
    private final Set<String> emails = new HashSet<>();
    private final Map<String, Student> byId = new HashMap<>();
    private final Map<String, String> emailById = new HashMap<>();

    public boolean addStudent(Student student, String email) {
        if (byId.containsKey(student.getId())) {
            return false;
        }

        if (!emails.add(email)) {
            return false;
        }

        students.add(student);
        byId.put(student.getId(), student);
        emailById.put(student.getId(), email);
        return true;
    }

    public Student findById(String id) {
        return byId.get(id);
    }

    public boolean containsEmail(String email) {
        return emails.contains(email);
    }

    public boolean removeById(String id) {
        Student removed = byId.remove(id);
        if (removed == null) {
            return false;
        }

        while (students.remove(removed)) {
            // remove all occurrences (defensive: list might be inconsistent)
        }

        String email = emailById.remove(id);
        if (email != null) {
            emails.remove(email);
        }

        return true;
    }

    public int studentCount() {
        return students.size();
    }

    public int emailCount() {
        return emails.size();
    }

    public int idCount() {
        return byId.size();
    }
}
