package ss7_abstract_interface.bai_tap.Colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] squares = new Shape[4];
        squares[0] = new Square(2);
        squares[1] = new SquareColor(3);
        squares[2] = new SquareColor(1);
        squares[3] = new Square(4);
        for (Shape shape: squares) {
            if(shape instanceof Colorable){
                shape.toStrings();
               ((Colorable) shape).howToColor();
            }
        }
    }
}
