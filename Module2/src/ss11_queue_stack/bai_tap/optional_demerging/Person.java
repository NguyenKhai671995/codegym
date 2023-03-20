package ss11_queue_stack.bai_tap.optional_demerging;

public class Person implements Comparable<Person> {
    private String name;
    private String gender;
    private String birthday;

    public Person() {
    }

    public Person(String name, String gender, String birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Person o) {
        if (this.gender.equalsIgnoreCase("Nu")) {
            if (this.name.compareToIgnoreCase(o.name) > 0) return 1;
            if (this.name.compareToIgnoreCase(o.name) < 0) return -1;
        }
        if (this.name.compareToIgnoreCase(o.name) > 0) return 1;
        if (this.name.compareToIgnoreCase(o.name) < 0) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
