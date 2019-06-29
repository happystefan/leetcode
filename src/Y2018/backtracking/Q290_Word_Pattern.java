package Y2018.backtracking;

import java.util.HashMap;
import java.util.Map;

public class Q290_Word_Pattern {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(key) && !map.get(key).equals(word)) return false;
            if (!map.containsKey(key) && map.containsValue(word)) return false;
            map.put(key, word);
        }
        return true;
    }

}
