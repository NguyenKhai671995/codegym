package ss11_queue_stack.bai_tap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {//0,0,0,1 -> 1000
        int[] reverse = {1,2,5,6};
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for(int ele : reverse){
            stack.push(ele); //1,2,5,6
        }
        int lenStack = stack.size();
        for (int i = 0; i < lenStack ; i++) {
            list.add(stack.pop());
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
}
