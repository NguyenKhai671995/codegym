package ss5_accessmodifier_staticmethod.bai_tap.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Student testStudent = new Student("khai","java");

        student.displayInfo();

        testStudent.displayInfo();
    }
}
