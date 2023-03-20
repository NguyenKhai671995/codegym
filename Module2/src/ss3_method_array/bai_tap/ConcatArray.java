package ss3_method_array.bai_tap;

import java.util.Arrays;

public class ConcatArray {
    public static int[] concat (int[] number1, int[] number2){
        int[] number3 = new int[number1.length + number2.length];
        for (int i = 0; i < number1.length ; i++) {
            number3[i] = number1[i];
        }
        for (int i = 0; i < number2.length ; i++) {
            number3[number1.length + i] = number2[i];
        }
        return number3;
    }
    public static void main(String[] args) {
        int [] number1= {10,3,2,0,0};
        int [] number2= {0,0,4,6,8};
        System.out.printf("New arrayNumber: %s", Arrays.toString(concat(number1,number2)));
    }
}
