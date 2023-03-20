package ss5_accessmodifier_staticmethod.bai_tap.Circle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Circle testCircle = new Circle(2);

        circle.displayInfo();
        testCircle.displayInfo();
    }
}
