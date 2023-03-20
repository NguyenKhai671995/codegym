package ss1_introduc.bai_tap;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input message: ");
        String message = scanner.nextLine();
        System.out.printf("Your message: %s people", message);
        //System.out.println("Your message: " + message +" people");
    }

}
