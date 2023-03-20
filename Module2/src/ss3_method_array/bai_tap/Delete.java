package ss3_method_array.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Delete {
    public static int searchValue(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return i;
        }
        return -1;
    }

    public static int[] deleteValue(int[] array, int value) {
        int[] result = new int[array.length];
        int idx = searchValue(array, value);
        for (int i = 0; i < array.length; i++) {
            if (i < idx) {
                result[i] = array[i];
            }
            if (i > idx) {
                result[i - 1] = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = new int[10];
        numbers[0] = 10;
        numbers[1] = 4;
        numbers[2] = 7;
        numbers[3] = 6;
        numbers[4] = 7;
        numbers[5] = 6;
        System.out.printf("Old array: %s\n", Arrays.toString(numbers));
        Scanner scanner = new Scanner(System.in);
        System.out.print("value you want delete: ");
        int value = scanner.nextInt();
        numbers = deleteValue(numbers,value);
        System.out.printf("New array: %s", Arrays.toString(numbers));
    }
}