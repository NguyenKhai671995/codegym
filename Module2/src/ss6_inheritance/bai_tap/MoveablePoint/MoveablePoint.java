package ss6_inheritance.bai_tap.MoveablePoint;

public class MoveablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    private float x = 0.0f;
    private float y = 0.0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{xSpeed, ySpeed};
    }

    public void toStrings(){
        System.out.printf("MoveablePoint x,y: %.2f , %.2f,\n speed: xSpeed %.2f, ySpeed %.2f \n",getX(),getY(),getxSpeed(),getySpeed());
    }

    public MoveablePoint move(){
        x+=xSpeed;
        y+=ySpeed;
        return this;
    }
}
