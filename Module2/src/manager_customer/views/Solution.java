package manager_customer.views;

import manager_customer.controller.PersonController;
import manager_customer.utils.HandedData;

import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    static PersonController personController = new PersonController();


    public static void main(String[] args) {
        loop:
        while (true) {
            System.out.println("1.Add New person\n2.Delete person\n3.Display person\n4.Quit\nYour Choice: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    displayAddNewPerson();
                    break;
                case "2":
                    personController.displayPerson();
                    HandedData.deletePerson(personController);
                    break;
                case "3":
                    personController.displayPerson();
                    break;
                default:
                    break loop;
            }
        }
    }

    private static void displayAddNewPerson() {
        System.out.println("1.Add New Employee\n2.Add New Student\n3.Quit");
        int choice = Integer.parseInt(scanner.nextLine());
        HandedData.addNewPerson(personController, choice);
    }
}
