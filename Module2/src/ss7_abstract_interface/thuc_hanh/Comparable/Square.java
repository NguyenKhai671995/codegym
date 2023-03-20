package ss7_abstract_interface.thuc_hanh.Comparable;

public class Square implements Comparable<Square> {
    private float slide;
    private String color = "red";

    public Square() {
    }

    public Square(float slide, String color) {
        this.slide = slide;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public float getSlide() {
        return slide;
    }
    public String toString(){
        return String.format("Square have color %s, slide %.2f\n",getColor(),getSlide());
    }

    @Override
    public int compareTo(Square o) {
        if (this.getSlide() > o.getSlide()) return 1;
        if (this.getSlide() < o.getSlide()) return -1;
        return this.getColor().compareToIgnoreCase(o.getColor());
    }
}
