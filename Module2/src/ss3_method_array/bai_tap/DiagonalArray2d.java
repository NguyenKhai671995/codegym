package ss3_method_array.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalArray2d {
    public static String displayArray2d(int[][] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += Arrays.toString(array[i]) + "\n";
        }
        return result;
    }
    public static void main(String[] args) {
        int result = 0;
        int ans = 0;
        Scanner scanner = new Scanner(System.in);
        int[][] numbers = new int[3][3];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.printf("input element %d, %d in array: ", i, j);
                numbers[i][j] = scanner.nextInt();
               if (i == j) {
                   result += numbers[i][j];
               }
               if (j==numbers.length - 1 - i){
                   ans += numbers[i][j];
               }
            }
        }
        System.out.printf("Array2d \n%s have diagonal left to right %d\ndiagonal right to left %d",displayArray2d(numbers),result,ans);
    }
}
