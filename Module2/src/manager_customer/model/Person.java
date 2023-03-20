package manager_customer.model;

public abstract class Person implements Comparable<Person>{
    private String idPerson;
    private String namePerson;
    private String birth;
    private String address;
    private int phone;

    public static String label = "idPerson,namePerson,birth,address,phone,salary,room,position,point,className,dateIN";

    public Person() {
    }

    public Person(String idPerson, String namePerson, String birth, String address, int phone) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public abstract String toString();

    public abstract String getData();

}
