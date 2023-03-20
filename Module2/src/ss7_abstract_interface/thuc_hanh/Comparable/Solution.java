package ss7_abstract_interface.thuc_hanh.Comparable;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Square[] squares = new Square[4];
        squares[0] = new Square(2,"red");
        squares[1] = new Square(2,"blue");
        squares[2] = new Square(1,"orange");
        squares[3] = new Square(1,"azure");
        System.out.println("Before: ");
        for (Square square: squares) {
            System.out.print(square.toString());
        }
        Arrays.sort(squares);
        System.out.println("After: ");
        for (Square square: squares) {
            System.out.print(square.toString());
        }
    }
}
