package ss11_queue_stack.bai_tap.optional_bracket;

import java.util.Stack;

public class Bracket {
    public static boolean isBracket(String str){
        //s * (s – a) * (s – b) * (s – c)→ Well
        Stack<Character> stackLeft = new Stack<>();
        Stack<Character> stackRight = new Stack<>();
        for (char ch: str.toCharArray()) {
            if (ch == '('){
                stackLeft.push(ch);
            }
            if (ch == ')'){
                stackRight.push(ch);
            }
        }
        return (stackLeft.size() == stackRight.size());
    }

    public static boolean isCorrect(String str){
        Stack<Character> stack = new Stack<>();
        for (char character: str.toCharArray()) {
            if(character == '('||character == '{'||character == '['){
                stack.push(character);
            }
            if(character == ')') {
                if(stack.empty() || stack.pop() != '(') return false;
            }
            if(character == '}') {
                if(stack.empty() || stack.pop() != '{' ) return false;
            }
            if(character == ']') {
                if(stack.empty() || stack.pop() != '[') return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isBracket("s * (s – a) * (s – b) * (s – c)"));
        System.out.println(isCorrect("{{s * (s – a)} {[ * (s – b)] * (s – c)}"));
    }
}
