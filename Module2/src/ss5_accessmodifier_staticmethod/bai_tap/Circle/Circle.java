package ss5_accessmodifier_staticmethod.bai_tap.Circle;

public class Circle {
    private final double PI = 3.14;
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    private double getRadius() {
        return radius;
    }

    private double getArea(){
        return Math.pow(radius,2)*PI;
    }
    private double getPerimeter(){
        return 2* PI * radius;
    }

    public void displayInfo(){
        System.out.printf("Circle with color %s radius %.2f getArea %.2f perimeter %.2f\n",color,getRadius(),getArea(),getPerimeter());
    }
}
