package ss4_class_object.bai_tap.Fan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeedFast();
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setOff(false);

        fan2.setSpeedMedium();
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOff(true);

        fan1.toStringFan();

        fan2.toStringFan();

    }
}
