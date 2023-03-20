package ss7_abstract_interface.bai_tap.Resizeable;

public class Circle extends Shape implements Resizeable {
    private final double PI = 3.14;
    private float radius = 1.0f;
    private String color = "red";

    public Circle() {
    }

    public Circle(float radius) {
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

    public void toStrings(){
        System.out.printf("Circle with color %s radius %.2f getArea %.2f perimeter %.2f\n",color,getRadius(),getArea(),getPerimeter());
    }

    public void resize(float percent) {
        double area = this.getArea();
        System.out.printf("new Area %.2f with percent %.2f %%\n",((100 - percent) / 100) * area,percent);

    }
}
