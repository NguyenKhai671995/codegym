package manager_customer.controller;

import manager_customer.model.Employee;
import manager_customer.model.Person;
import manager_customer.model.Student;
import manager_customer.services.PersonInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonController implements PersonInterface {
    public List<Person> personList = new ArrayList<>();

    public PersonController() {
        readCSV();
    }

    public static String filePath = "src\\manager_customer\\file\\data\\personal_records.csv";

    public static String COMMA_DELIMITER = ",";


    public void saveCSV() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(Person.label);
            bufferedWriter.newLine();
            for (Person e : personList) {
                bufferedWriter.write(e.getData());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readCSV() {
        File file = new File(filePath);
        if (file.length() == 0) return;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            boolean flagFirstLine = true;
            String currentLine = "";
            while ((currentLine = bufferedReader.readLine()) != null) {
                if (flagFirstLine) {
                    flagFirstLine = false;
                    continue;
                }
                String[] data = currentLine.split(COMMA_DELIMITER);
                if (data[data.length - 1].equalsIgnoreCase("empty")) {
                    Employee employee = new Employee(data[0], data[1], data[2],
                            (data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), data[6], data[7]);
                    addNew(employee);
                } else {
                    Student student = new Student(data[0], data[1], data[2],
                            (data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[8]), (data[9]), data[10]);
                    addNew(student);
                }

            }
        } catch (IOException e) {
            e.getMessage();
        }

    }

    public boolean isNotExistPerson(String id) {
        return searchById(id) == null;
    }

    public Person searchById(String id) {
        for (Person e : personList) {
            if (e.getIdPerson().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }

    public void addNew(Person newPerson) {
        if (isNotExistPerson(newPerson.getIdPerson())) {
            personList.add(newPerson);
        }
    }

    public void deletePerson(String id) {
        personList.remove(searchById(id));
    }

    public void displayPerson() {
        Collections.sort(personList);
        for (Person e : personList) {
            System.out.println(e);
        }
    }

}
