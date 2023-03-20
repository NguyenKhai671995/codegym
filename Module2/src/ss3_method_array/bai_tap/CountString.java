package ss3_method_array.bai_tap;

import java.util.Scanner;

public class CountString {
    public static void main(String[] args) {
        int count = 0;
        String str = "Hello java";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input character: ");
        char value = scanner.nextLine().charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (Character.toString(str.toLowerCase().charAt(i)).equals(Character.toString(value).toLowerCase())) {
                count++;
            }
        }
        System.out.printf("String %s have %d character %s", str, count, value);
    }
}
