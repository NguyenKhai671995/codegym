package manager_customer.utils;

import manager_customer.controller.PersonController;
import manager_customer.model.Employee;
import manager_customer.model.Student;

public class HandedData {

    public static void addNewPerson(PersonController personController, int choice) {
        String idPerson;
        do {
            idPerson = RegExCheck.getStringValue("id person");
            if (RegExCheck.isCorrectIdPerson(idPerson)) {
                try {
                    DuplicatePersonalRecordException.checkIdCorrectType(personController,idPerson);
                } catch (DuplicatePersonalRecordException e) {
                    RegExCheck.getStringValue(e.getMessage());
                }
                break;
            }
            RegExCheck.getStringValue("idPerson MUST NV-XXX or HV-XXX");

        } while (true);

        String namePerson = RegExCheck.getStringValue("name person");
        String birth;
        do {
            birth = RegExCheck.getStringValue("birth");
            if (RegExCheck.isCorrectDate(birth)){
                break;
            }
            RegExCheck.getStringValue("birth is dd/MM/yyyy");
        }while (true);

        String address = RegExCheck.getStringValue("address");
        int phone = Integer.parseInt(RegExCheck.getStringValue("phone"));

        switch (choice) {
            case 1:
                int salary = Integer.parseInt(RegExCheck.getStringValue("salary"));
                String room = RegExCheck.getStringValue("room");
                String position = RegExCheck.getStringValue("position");
                personController.addNew(new Employee(idPerson, namePerson, birth, address, phone, salary, room, position));
                break;
            case 2:
                int point = Integer.parseInt(RegExCheck.getStringValue("point"));
                String className = RegExCheck.getStringValue("class name");
                String dateIn ;
                do {
                    dateIn = RegExCheck.getStringValue("day in");
                    if (RegExCheck.isCorrectDate(dateIn)){
                        break;
                    }
                    RegExCheck.getStringValue("Day in is dd/MM/yyyy");
                }while (true);
                personController.addNew(new Student(idPerson,namePerson,birth,address,phone,point,className,dateIn));
                break;
            default:
                break;
        }
        personController.saveCSV();
        System.out.println("Add New Successfully");

    }
    public static void deletePerson(PersonController personController) {
        String id;
        while (true) {
            try {
                id = (RegExCheck.getStringValue("input id delete"));
                DuplicatePersonalRecordException.checkIdIsExist(personController,id);
                String option = RegExCheck.getStringValue("You Want Delete: Yes or No ");
                if (option.equalsIgnoreCase("yes")) {
                    personController.deletePerson(id);
                    RegExCheck.getStringValue("Delete successfully");
                    return;
                }
                System.out.println("Not Delete");
                return;
            }catch (DuplicatePersonalRecordException e) {
                e.getMessage();
            }
        }
    }



}
