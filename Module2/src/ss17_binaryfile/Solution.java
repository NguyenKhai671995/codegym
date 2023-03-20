package ss17_binaryfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    static List<Product> products = new ArrayList<>();

    static String file_name = "D:\\cody\\A0222I1-NguyenKhai\\Module2\\src\\ss17_binaryfile\\binaryfile.dat";

    static String file_name_copy = "D:\\cody\\A0222I1-NguyenKhai\\Module2\\src\\ss17_binaryfile\\copy.dat";

    public static void main(String[] args) {
        System.out.println("1.Add New\n2.Display\n3.Search\n4.Copy and display\n5.Quit");
        String option = scanner.nextLine();
        switch (option){
            case "1":
                displayAddNew();
                break;
            case "2":
                displayList();
                break;
            case "3":
                displaySearch();
                break;
            case "4":
                displayCopy();
                break;
            default:
                break;
        }
    }

    public static void displayCopy() {
        List<Product> copy = new ArrayList<>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file_name))){
            copy =(List<Product>) objectInputStream.readObject();
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for (Product pro : copy) {
            System.out.println(pro);
        }

        saveFileBinary(file_name_copy,copy);
    }



    public static void displaySearch() {
        System.out.println("input id search");
        String idSearch = scanner.nextLine();
        for (Product pro:products) {
            if (pro.id.equalsIgnoreCase(idSearch)){
                System.out.println(pro);
                return;
            }
        }
        System.out.println("Not found");
    }

    public static void displayList() {
        for (Product pro:products) {
            System.out.println(pro);
        }
    }

    public static void displayAddNew() {
        System.out.println("input id");
        String id = scanner.nextLine();
        System.out.println("input name");
        String name = scanner.nextLine();
        System.out.println("input manufacture");
        String manufacture = scanner.nextLine();
        System.out.println("input price");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("input other");
        String other = scanner.nextLine();
        products.add(new Product(id,name,manufacture,price,other));
        saveFileBinary(file_name,products);
    }

    public static void saveFileBinary(String file_name,List<Product> list){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file_name))){
            objectOutputStream.writeObject(list);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



}
