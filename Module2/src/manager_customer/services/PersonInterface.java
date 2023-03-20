package manager_customer.services;

import manager_customer.model.Person;

public interface PersonInterface {
    void saveCSV();

    void readCSV();

    boolean isNotExistPerson(String id);

    Person searchById(String id);

    void addNew(Person newPerson);

    void deletePerson(String id);

    void displayPerson();

}
