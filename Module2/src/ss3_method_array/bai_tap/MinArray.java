package ss3_method_array.bai_tap;

public class MinArray {
    public static void main(String[] args) {
        int [] numbers= {10,3,2,1,3,4,5};
        int MIN = 100000;
        for (int number : numbers) {
            if (number < MIN) {
                MIN = number;
            }
        }
        System.out.printf("Min is array is: %d", MIN);
    }
}
