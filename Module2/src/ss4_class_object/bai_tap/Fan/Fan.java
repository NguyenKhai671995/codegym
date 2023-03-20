package ss4_class_object.bai_tap.Fan;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = SLOW;
    private boolean off = false ;
    private double radius = 5 ;
    private String color = "blue";

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSpeedMedium(){
        this.speed = MEDIUM;
    }

    public void setSpeedFast(){
        this.speed = FAST;
    }

    public boolean isOff() {
        return off;
    }

    public void setOff(boolean off) {
        this.off = off;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {

    }

    public Fan(int speed, boolean off, double radius, String color) {
        this.speed = speed;
        this.off = off;
        this.radius = radius;
        this.color = color;
    }

    public void toStringFan(){
        if (!isOff()){
            System.out.printf("Fan on with speed %d, color %s, radius %.2f\n",getSpeed(),getColor(),getRadius());
        }else {
            System.out.printf("Fan off, color %s, radius %.2f\n",getColor(),getRadius());
        }
    }

}

