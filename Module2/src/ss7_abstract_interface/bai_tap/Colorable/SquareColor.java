package ss7_abstract_interface.bai_tap.Colorable;

public class SquareColor extends Shape implements Colorable{
    private float slide;

    public SquareColor(float slide){
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

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
