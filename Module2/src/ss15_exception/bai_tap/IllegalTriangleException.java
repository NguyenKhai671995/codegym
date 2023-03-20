package ss15_exception.bai_tap;

public class IllegalTriangleException extends Exception {
    String errorLine;

    public IllegalTriangleException(String errorLine) {
        this.errorLine = errorLine;
    }

    @Override
    public String getMessage() {
        return errorLine;
    }

    public static void checkCorrectTriangle(int a, int b, int c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) throw new IllegalTriangleException("a,b,c > 0");
        if (a + b < c || a + c < b || b + c < a) throw new IllegalTriangleException("Is not triangle");
    }
}
