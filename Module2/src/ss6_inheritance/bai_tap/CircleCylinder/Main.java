package ss6_inheritance.bai_tap.CircleCylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Circle circle1 = new Circle(3,"blue");

        Cylinder cylinder = new Cylinder();
        Cylinder cylinder1 = new Cylinder(4,"yellow",10);

        circle.displayInfo();
        circle1.displayInfo();

        cylinder.displayInfo();
        cylinder1.displayInfo();

    }
}
