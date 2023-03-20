package ss11_queue_stack.bai_tap.optional_palindrome;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(String str){
        Queue queue = new ArrayDeque();
        Stack stack = new Stack();
        for (char ch :str.toLowerCase().toCharArray()){
            stack.push(ch);
            queue.add(ch);
        }
        int size = str.length();
        for (int i = 0; i < size ; i++) {
            if(stack.pop() != queue.poll()) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("Able was I ere I saw Elba"));
    }
}
