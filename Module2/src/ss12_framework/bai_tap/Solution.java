package ss12_framework.bai_tap;

import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        loop:
        while (true) {
            System.out.print("1.Add New\n2.EditByID\n" +
                    "3.Delete\n4.Display\n5.SearchByName\n" +
                    "6.SortLow\n7.SortHigh\n8.Quit\nYourChoice ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    displayAddNew();
                    break;
                case "2":
                    displayEditById();
                    break;
                case "3":
                    displayDelete();
                    break;
                case "4":
                    productManager.displayList();
                    break;
                case "5":
                    displaySearchByName();
                    break;
                case "6":
                    productManager.sortPriceToLow();
                    productManager.displayList();
                    break;
                case "7":
                    productManager.sortPriceToHigh();
                    productManager.displayList();
                    break;
                default:
                    break loop;
            }
        }
    }

    static void displayAddNew() {
        System.out.println("id: ");
        String id = scanner.nextLine();
        System.out.println("name: ");
        String name = scanner.nextLine();
        System.out.println("price: ");
        int price = Integer.parseInt(scanner.nextLine());
        productManager.addNew(new Product(id,name,price));
    }

    static void displayEditById(){
        System.out.println("id: ");
        String id = scanner.nextLine();
        if (productManager.isNotExistProduct(id)) {
            System.out.println("Not found");
            return;
        }
        System.out.println(productManager.searchById(id));
        System.out.println("name: ");
        String name = scanner.nextLine();
        System.out.println("price: ");
        int price = Integer.parseInt(scanner.nextLine());
        productManager.editById(id,name,price);
    }

    static void displayDelete(){
        System.out.println("id: ");
        String id = scanner.nextLine();
        productManager.deleteById(id);
    }

    static void displaySearchByName(){
        System.out.println("name: ");
        String name = scanner.nextLine();
        System.out.println(productManager.searchByName(name));
    }

}
