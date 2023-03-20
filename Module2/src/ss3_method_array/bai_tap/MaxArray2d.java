package ss3_method_array.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MaxArray2d {
    public static String displayArray2d(int[][] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += Arrays.toString(array[i]) + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] numbers = new int[3][3];
        int MAX = -9999999;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.printf("input element %d, %d in array: ", i, j);
                numbers[i][j] = scanner.nextInt();
                if (numbers[i][j] > MAX) {
                    MAX = numbers[i][j];
                }
            }
        }
        System.out.printf("Array\n%s have MAX is %d", displayArray2d(numbers), MAX);
    }
}
