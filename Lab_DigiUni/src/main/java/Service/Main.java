package Rep;

public class Main {
    static void main() {
        Teacher decan = new Teacher();
        Student ya = new Student("Олекс");
        University myUni = new University("Могила","НаУКМА","Київ","Борисоглібська");
        Faculty myFac = new Faculty(1L, "Факультет інформатики", "ФІ","fi@gmail.com", 671111111);
        Department myDep = new Department(1L, "Кафедра мережок", myFac, 1, 311);
        Department notMyDep = new Department(1L, "Кафедра математики", myFac, 1, 301);
        myFac.addDepartment(myDep);
        myFac.addDepartment(notMyDep);
        System.out.println(myFac.getDepartments());

    }

}
