package ss15_exception.bai_tap;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        while (true) {
            try {
                System.out.print("Input a: ");
                a = scanner.nextInt();
                System.out.print("Input a: ");
                b = scanner.nextInt();
                System.out.print("Input a: ");
                c = scanner.nextInt();
                IllegalTriangleException.checkCorrectTriangle(a,b,c);
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
