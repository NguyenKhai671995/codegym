package ss1_introduc.bai_tap;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        int number;
        int hundred;
        int dozens;
        int unitDigits;
        String result = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input your number: ");
            number = scanner.nextInt();
            if (number > 0) break;
        }
        if (number > 20) {
            dozens = (int) Math.floor(number / 10);
            unitDigits = (int) number % 10;
            switch (dozens) {
                case 3:
                    result += "thirty";
                    break;
                case 4:
                    result += "forty";
                    break;
                case 5:
                    result += "fifty";
                    break;
                case 6:
                    result += "sixty";
                    break;
                case 7:
                    result += "seventy";
                    break;
                case 8:
                    result += "eighty";
                    break;
                case 9:
                    result += "ninety";
                    break;
            }
            switch (unitDigits) {
                case 1:
                    result += "one";
                    break;
                case 2:
                    result += "two";
                    break;
                case 3:
                    result += "three";
                    break;
                case 4:
                    result += "four";
                    break;
                case 5:
                    result += "five";
                    break;
                case 6:
                    result += "six";
                    break;
                case 7:
                    result += "seven";
                    break;
                case 8:
                    result += "eight";
                    break;
                case 9:
                    result += "nine";
                    break;
            }
        } else if (number <= 20) {
            if (number >= 10) {
                switch (number) {
                    case 10:
                        result += "ten";
                        break;
                    case 11:
                        result += "eleven";
                        break;
                    case 12:
                        result += "twelve";
                        break;
                    case 13:
                        result += "thirteen";
                        break;
                    case 14:
                        result += "fourteen";
                        break;
                    case 15:
                        result += "fifteen";
                        break;
                    case 16:
                        result += "sixteen";
                        break;
                    case 17:
                        result += "seventeen";
                        break;
                    case 18:
                        result += "eighteen";
                        break;
                    case 19:
                        result += "nineteen";
                        break;
                    case 20:
                        result += "twenty";
                        break;
                }
            } else {
                switch (number) {
                    case 1:
                        result += "one";
                        break;
                    case 2:
                        result += "two";
                        break;
                    case 3:
                        result += "three";
                        break;
                    case 4:
                        result += "four";
                        break;
                    case 5:
                        result += "five";
                        break;
                    case 6:
                        result += "six";
                        break;
                    case 7:
                        result += "seven";
                        break;
                    case 8:
                        result += "eight";
                        break;
                    case 9:
                        result += "nine";
                        break;
                }
            }
        }
        System.out.println(result);
    }
}
