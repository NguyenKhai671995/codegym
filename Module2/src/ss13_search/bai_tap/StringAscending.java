package ss13_search.bai_tap;

import java.util.Stack;

public class StringAscending {
    public static void main(String[] args) {
        String str = "Welcome";
        System.out.println(findLongest(str));
    }

    static Stack<String> findLongest(String str){
        Stack<String> ans = new Stack<>();
        int Max = Integer.MIN_VALUE;
        Stack<String> result = new Stack<>();
        for (String element: str.split("")) {
            if (ans.empty()){
                ans.push(element);
                continue;
            }

            if (element.compareTo(ans.peek()) < 0 ){
                continue;
            }

            ans.push(element);
            if (Max < ans.size()){
                Max = ans.size();
                result = ans;
            }
        }
        return result;
    }
}
