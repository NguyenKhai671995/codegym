package ss4_class_object.bai_tap.QuadraticEquation;

public class QuadraticEquation {
    private float a, b, c;

    private float delta = getDiscriminant();

    public QuadraticEquation() {

    }

    public QuadraticEquation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.delta = getDiscriminant();
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    private float getDiscriminant() {
        return (float) (Math.pow(b, 2) - (4 * a * c));
    }

    private float getRoot1() {
        return (float) ((-b + Math.sqrt(delta)) / (2 * a));
    }

    private float getRoot2() {
        return (float) ((-b - Math.sqrt(delta)) / (2 * a));
    }

    private float getRoot0() {
        return (float) (-b / (2 * a));
    }

    public void findRoot() {
        if (delta < 0) {
            System.out.println("Phuong trinh vo nghiem");
        } else if (delta > 0) {
            System.out.printf("Phuong trinh co 2 nghiem x1: %.2f \t x2: %.2f", getRoot1(), getRoot2());
        } else {
            System.out.printf("Phuong trinh co 1 nghiem x: %.2f ", getRoot0());
        }
    }
}

