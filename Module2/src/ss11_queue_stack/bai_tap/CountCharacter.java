package ss11_queue_stack.bai_tap;

import java.util.Map;
import java.util.TreeMap;

public class CountCharacter {
    public static Map<Character, Integer> countCharacter(String str) {
        Map<Character, Integer> answer = new TreeMap<>();
        for (Character character : str.toLowerCase().toCharArray()) {
            answer.put(character, answer.getOrDefault(character, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        String str = "asdasdASsd";
        for (Map.Entry<Character, Integer> entry : countCharacter(str).entrySet()) {
            System.out.println(entry.getKey() + " have " + entry.getValue());
        }
    }
}
