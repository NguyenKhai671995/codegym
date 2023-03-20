package ss6_inheritance.bai_tap.Triangle;

public class Triangle extends Shape {
    private float side1 = 1.0f;
    private float side2 = 1.0f;
    private float side3 = 1.0f;
    private String color = "red";
    public Triangle() {
    }

    public Triangle(float side1, float side2, float side3, String color) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.color = color;
    }

    public float getSide1() {
        return side1;
    }

    public void setSide1(float side1) {
        this.side1 = side1;
    }

    public float getSide2() {
        return side2;
    }

    public void setSide2(float side2) {
        this.side2 = side2;
    }

    public float getSide3() {
        return side3;
    }

    public void setSide3(float side3) {
        this.side3 = side3;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    float getPerimeter() {
        return (side1 + side2 + side3);
    }

    @Override
    float getArea() {
        return side1 * side2 * side3;
    }

    @Override
    String toStrings() {
          return String.format("triangle with color %s side1 %.2f, side2 %.2f, side3 %.2f\n getArea %.2f \nperimeter %.2f\n",getColor(),getSide1(),getSide2(),getSide3(),getArea(),getPerimeter());
    }
}
