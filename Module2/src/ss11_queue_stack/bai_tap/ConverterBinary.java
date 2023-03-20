package ss11_queue_stack.bai_tap;

import java.util.*;

public class ConverterBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Stack<Integer> stack = new Stack<>();
        String str = new String();
        while (num > 0) {
            int numb = num % 2;
            stack.push(numb);
            num = (int) Math.floor(num / 2);
        }
        while (!stack.empty()){
            str += stack.pop();
        }
        System.out.println(str);
    }
}

