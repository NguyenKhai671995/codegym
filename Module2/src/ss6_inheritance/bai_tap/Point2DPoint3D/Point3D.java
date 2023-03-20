package ss6_inheritance.bai_tap.Point2DPoint3D;

public class Point3D extends Point2D{
    private float z = 0.0f;
    private float x= 0.0f;
    private float y = 0.0f;

    public Point3D() {
    }

    public Point3D(float z, float x, float y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public void setXYZ(float x, float y,float z) {
        this.x = x;
        this.y = y;
        this.z = z;


    }

    public float[] getXYY() {
        return new float[]{getX(),getY(),getZ()};
    }

    public void toStrings(){
        System.out.printf("point 3d x,y,z: %s , %s, %s\n",getX(),getY(),getZ());
    }
}
