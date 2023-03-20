package ss2_loop.bai_tap;

import java.util.Scanner;

public class Prime100 {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String result = "";
        for (int i = 2 ; i <= 100 ; i++) {
            if (isPrime(i)) {
                result += i + "\t";
            }
        }
        System.out.println(result);
    }
}
