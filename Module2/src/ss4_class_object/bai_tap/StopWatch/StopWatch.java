package ss4_class_object.bai_tap.StopWatch;

import java.util.Date;

public class StopWatch {
    private double startTime;

    private double endTime;

    public StopWatch() {
        startTime = new Date().getTime();
    }

    public void startTime() {
        startTime = new Date().getTime();
    }

    public void endTime() {
        endTime = new Date().getTime();
    }

    public double getElapsedTime() {
        return endTime - startTime;
    }
}
