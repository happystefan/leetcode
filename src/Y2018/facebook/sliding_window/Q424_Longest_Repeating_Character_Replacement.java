package Y2018.facebook.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Q424_Longest_Repeating_Character_Replacement {

    public int characterReplacement(String s, int k) {
        char[] ss = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, result = 0;
        int max = 0;
        while (r < ss.length) {
            map.put(ss[r], map.getOrDefault(ss[r], 0) + 1);
            max = Math.max(max, map.get(ss[r]));
            r++;
            while ((r - l) > max + k) {
                map.put(ss[l], map.get(ss[l]) - 1);
                l++;
            }
            result = Math.max(result, r - l);
        }
        return result;
    }

}
