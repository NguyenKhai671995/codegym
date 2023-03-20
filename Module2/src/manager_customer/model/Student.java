package manager_customer.model;

public class Student extends Person {
    private int point;
    private String className;
    private String dateIn;

    public Student(int point, String className, String dateIn) {
        this.point = point;
        this.className = className;
        this.dateIn = dateIn;
    }

    public Student(String id, String name, String birth, String address, int phone, int point, String className, String dateIn) {
        super(id, name, birth, address, phone);
        this.point = point;
        this.className = className;
        this.dateIn = dateIn;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getIdPerson() + '\'' +
                ", name='" + getNamePerson() + '\'' +
                ", birth='" + getBirth() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone=" + getPhone() +
                ", salary=" + point +
                ", room='" + className + '\'' +
                ", position='" + dateIn + '\'' +
                '}';
    }

    public String getData() {
        return String.format("%s,%s,%s,%s,%d,empty,empty,empty,%d,%s,%s",
                getIdPerson(), getNamePerson(), getBirth(), getAddress(), getPhone(),
                point, className, dateIn);
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
