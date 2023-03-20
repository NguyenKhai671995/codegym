package ss6_inheritance.bai_tap.CircleCylinder;

public class Cylinder extends Circle{
    private final double PI = 3.14;
    private double radius = 3.5;
    private String color = "azure";
    private double width = 5;

    public Cylinder(double radius, String color, double width) {
        this.radius = radius;
        this.color = color;
        this.width = width;
    }

    public Cylinder() {
    }

    @Override
    public double getPI() {
        return PI;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    private double getArea(){
        return 2 * PI * radius *(radius +  width);
    }


    private double getVolume(){
        return PI * width * Math.pow(radius,2);
    }

    public void displayInfo(){
        System.out.printf("Cylinder with color %s radius %.2f getArea %.2f Volume %.2f\n",getColor(),getRadius(),getArea(),getVolume());
    }
}
