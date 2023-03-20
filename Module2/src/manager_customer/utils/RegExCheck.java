package manager_customer.utils;

import java.util.Scanner;

public class RegExCheck {
    static Scanner scanner = new Scanner(System.in);

    public static String getStringValue(String line) {
        boolean flagAgain = false;
        while (true) {
            String currentLine = flagAgain ? String.format("Input %s again", line) : String.format("Input %s", line);
            System.out.println(currentLine);
            String str = scanner.nextLine();
            if (!str.trim().isEmpty()) {
                return str;
            }

            System.out.println("Input something");
            flagAgain = true;
        }
    }

    public static boolean isCorrectIdPerson(String str) {
        return str.matches("^([N][V]|[H][V])-[\\d]{3}");
    }

    public static boolean isCorrectDate(String str) {
        return str.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
    }
}
