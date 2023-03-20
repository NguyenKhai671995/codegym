package ss7_abstract_interface.bai_tap.Colorable;

public class Square extends Shape {
    private float slide;

    public Square(float slide){
        this.slide = slide;
    }

    public float getArea(){
        return slide * slide;
    }

    public float getPerimeter(){
        return slide*4;
    }

    public float getSlide() {
        return slide;
    }

    public void toStrings(){
        System.out.printf("SquareColor have slide %.2f getArea %.2f, getPerimeter %.2f\n",getSlide(),getArea(),getPerimeter());
    }
}
