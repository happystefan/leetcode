package facebook.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Q003_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int result = 0;
        while (r < ss.length) {
            map.put(ss[r], map.getOrDefault(ss[r], 0) + 1);
            r++;
            while (r - l > map.size()) {
                map.put(ss[l], map.get(ss[l]) - 1);
                if (map.get(ss[l]) == 0) map.remove(ss[l]);
                l++;
            }
            result = Math.max(result, r - l);
        }
        return result;
    }

}
