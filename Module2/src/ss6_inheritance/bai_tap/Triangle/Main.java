package ss6_inheritance.bai_tap.Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Triangle triangle = new Triangle(1,2,3,"blue");
//        System.out.println(triangle.toStrings());

        Scanner scanner = new Scanner(System.in);
        Triangle triangle1 = new Triangle();
        System.out.println("canh 1: ");
        int slide1 = Integer.parseInt(scanner.nextLine());
        System.out.println("canh 2: ");
        int slide2 = Integer.parseInt(scanner.nextLine());
        System.out.println("canh 3: ");
        int slide3 = Integer.parseInt(scanner.nextLine());
        System.out.println("color: ");
        String color = scanner.nextLine();
        triangle1.setSide1(slide1);
        triangle1.setSide2(slide2);
        triangle1.setSide3(slide3);
        triangle1.setColor(color);
        System.out.println(triangle1.toStrings());
    }
}
