package Y2019.Q0001_Q0300;

import java.util.HashMap;
import java.util.Map;

public class Q0290_Word_Pattern {

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] ss = str.split(" ");
        if (pattern.length() != ss.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = ss[i];
            if (map.containsKey(c) && !map.get(c).equals(s)) return false;
            if (!map.containsKey(c) && map.containsValue(s)) return false;
            map.put(c, s);
        }
        return true;
    }

}
