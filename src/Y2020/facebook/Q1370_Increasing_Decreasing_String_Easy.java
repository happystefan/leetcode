package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q1370_Increasing_Decreasing_String_Easy {

    public String sortString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuffer sb = new StringBuffer();
        while (sb.length() < s.length()) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (!map.containsKey(c)) continue;
                sb.append(c);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
            }
            for (char c = 'z'; c >= 'a'; c--) {
                if (!map.containsKey(c)) continue;
                sb.append(c);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
            }
        }
        return sb.toString();
    }

}
