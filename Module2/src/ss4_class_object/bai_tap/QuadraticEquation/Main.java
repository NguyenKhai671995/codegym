package ss4_class_object.bai_tap.QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap a: ");
        float a = scanner.nextFloat();
        System.out.print("Nhap b: ");
        float b = scanner.nextFloat();
        System.out.print("Nhap c: ");
        float c = scanner.nextFloat();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        quadraticEquation.findRoot();
    }
}
