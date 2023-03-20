package ss5_accessmodifier_staticmethod.bai_tap.Student;

public class Student {
    private String name = "john";
    private String classes = "C02";

    public Student() {
    }

    public Student(String name,String classes){
        this.name = name;
        this.classes = classes;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setClasses(String classes) {
        this.classes = classes;
    }

    public void displayInfo(){
        System.out.printf("Student have name %s in class %s\n",name,classes);
    }
}
