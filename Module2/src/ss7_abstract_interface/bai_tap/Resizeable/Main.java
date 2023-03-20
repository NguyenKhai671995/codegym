package ss7_abstract_interface.bai_tap.Resizeable;

public class Main {
    public static void main(String[] args) {
        Shape[] shape = new Shape[5];
        shape[0] = new Square(3);
        shape[0].toStrings();
        shape[0].resize(15);
        shape[1] = new Triangle(3,4,5,"blue");
        shape[1].toStrings();
        shape[1].resize(10);
        shape[2] = new Circle(3);
        shape[2].toStrings();
        shape[2].resize(20);
    }
}
