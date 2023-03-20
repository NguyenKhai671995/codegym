package manager_customer.model;

public class Employee extends Person {
    private int salary;
    private String room;
    private String position;

    public Employee(int salary, String room, String position) {
        this.salary = salary;
        this.room = room;
        this.position = position;
    }

    public Employee(String id, String name, String birth, String address, int phone, int salary, String room, String position) {
        super(id, name, birth, address, phone);
        this.salary = salary;
        this.room = room;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + getIdPerson() + '\'' +
                ", name='" + getNamePerson() + '\'' +
                ", birth='" + getBirth() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone=" + getPhone() +
                ", salary=" + salary +
                ", room='" + room + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public String getData() {
        return String.format("%s,%s,%s,%s,%d,%d,%s,%s,empty,empty,empty",
                getIdPerson(), getNamePerson(), getBirth(), getAddress(), getPhone(),
                salary, room, position);
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
