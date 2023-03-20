package ss4_class_object.bai_tap.StopWatch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[100000];
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        stopWatch.endTime();
        System.out.printf("Thoi gian troi qua: %.3f millisecond", stopWatch.getElapsedTime());
        stopWatch.startTime();
        Arrays.sort(numbers);
        stopWatch.endTime();
        System.out.printf("\nThoi gian troi qua: %.3f millisecond", stopWatch.getElapsedTime());
    }
}
