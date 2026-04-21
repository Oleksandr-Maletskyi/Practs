package Repository;

import Domain.University;
import java.io.*;

public class FileStorage {
    private static final String FILE_NAME = "university_data.dat";

    public static void save(University university) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(university);
            System.out.println("Всі дані успішно збережено у файл!");
        } catch (IOException e) {
            System.out.println("Помилка збереження файлу: " + e.getMessage());
        }
    }

    public static University load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Дані успішно завантажено з файлу!");
            return (University) ois.readObject();
        } catch (Exception e) {
            System.out.println("Файл збереження не знайдено. Створено новий чистий Університет.");
            return new University();
        }
    }
}
