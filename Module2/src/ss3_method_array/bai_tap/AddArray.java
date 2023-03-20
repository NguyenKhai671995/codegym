package ss3_method_array.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddArray {
    public static void main(String[] args) {
        int [] numbers= {10,3,2,1,3,0,0,0,0,0};
        Scanner scanner = new Scanner(System.in);
        System.out.println("input index: ");
        int idx = scanner.nextInt();
        System.out.println("input number: ");
        int value = scanner.nextInt();
        numbers[idx] = value;
        System.out.println(Arrays.toString(numbers));
    }
}
