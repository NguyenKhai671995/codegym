import java.util.HashMap;
import java.util.Map;

public class Dictionary {
   static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello","xin chao");
        dictionary.put("age","tuoi");
        dictionary.put("name","ten");
        dictionary.put("nation","quoc gia");
    }
    public static String search(String key){
        return dictionary.get(key);
    }

}
