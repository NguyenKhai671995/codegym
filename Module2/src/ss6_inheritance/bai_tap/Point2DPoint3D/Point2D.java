package ss6_inheritance.bai_tap.Point2DPoint3D;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{getX(),getY()};
    }

    public void toStrings(){
        System.out.printf("point 2d x,y: %s , %s\n",getX(),getY());
    }
}
