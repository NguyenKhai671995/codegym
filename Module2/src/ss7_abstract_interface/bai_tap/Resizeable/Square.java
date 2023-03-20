package ss7_abstract_interface.bai_tap.Resizeable;

public class Square extends Shape implements Resizeable{
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


    public void resize(float percent){
       float area = this.getArea();
       System.out.printf("new Area %.2f with percent %.2f %%\n",((100 - percent) / 100) * area,percent);

    }
}
