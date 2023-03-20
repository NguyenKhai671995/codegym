package ss6_inheritance.bai_tap.CircleCylinder;

public class Circle {
    private final double PI = 3.14;
    private double radius = 1.0;
    private String color = "red";

    public double getPI() {
        return PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public Circle() {
    }

    public Circle(double radius,String color) {
        this.radius = radius;
        this.color = color;
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
