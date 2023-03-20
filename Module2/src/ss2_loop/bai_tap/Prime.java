package ss2_loop.bai_tap;

import java.util.Scanner;

public class Prime {
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
        int count = 0;
        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number is prime number you want to print:");
        int number = Integer.parseInt(scanner.nextLine());
            if (number > 20 || number <= 0) {
                System.out.println("input wrong type: 0 < number <= 20");
            } else {
                for (int i = 2; i < 100; i++) {
                    if (isPrime(i)) {
                        result += i + "\t";
                        count++;
                    }
                    if (count == number) {

                    }
                }
                System.out.println(result); }
        }
    }

