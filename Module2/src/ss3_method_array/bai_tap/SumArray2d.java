package ss3_method_array.bai_tap;

import java.util.Scanner;

public class SumArray2d {
    public static void main(String[] args) {
        int result = 0;
        int[][] numbs = {{1, 2, 3, 4}, {4, 5, 6, 7}};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Column you want to sum: ");
        int column = scanner.nextInt();
        for (int i = 0; i < numbs.length; i++) {
            for (int j = 0; j < numbs[i].length ; j++) {
                if (j == column){
                    result += numbs[i][j];
                }
            }
        }
        System.out.printf("Sum column %d in array: %d", column,result);
    }
}
