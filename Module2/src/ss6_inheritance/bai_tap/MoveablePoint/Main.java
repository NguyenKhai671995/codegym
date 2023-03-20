package ss6_inheritance.bai_tap.MoveablePoint;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3,5);
        MoveablePoint moveablePoint = new MoveablePoint(3,4,5,6);

        point.toStrings();
        moveablePoint.toStrings();
    }
}
