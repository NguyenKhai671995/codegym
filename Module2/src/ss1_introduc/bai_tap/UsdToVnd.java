package ss1_introduc.bai_tap;

import java.util.Scanner;

public class UsdToVnd {
    public static void main(String[] args) {
        float USD;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Usd: ");
        USD = scanner.nextFloat();
        float change = USD * 23000;
        System.out.printf("Tien Viet Nam: %.2f", change);
    }
}
