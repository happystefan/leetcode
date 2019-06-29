package range_query;

import java.util.HashMap;
import java.util.Map;

public class Q395_Longest_Substring_with_At_Least_K_Repeating_Characters {

    public int longestSubstring(String s, int k) {
        char[] ss = s.toCharArray();
        int result = 0;
        for (int i = 1; i <= 26; i++) {
            int l = 0, r = 0;
            int atLeastK = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (r < s.length()) {
                if (map.size() <= i) {
                    map.put(ss[r], map.getOrDefault(ss[r], 0) + 1);
                    if (map.get(ss[r]) == k) {
                        atLeastK++;
                    }
                    r++;
                } else {
                    map.put(ss[l], map.getOrDefault(ss[l], 0) - 1);
                    if (map.get(ss[l]) == k - 1) {
                        atLeastK--;
                    }
                    if (map.get(ss[l]) == 0) {
                        map.remove(ss[l]);
                    }
                    l++;
                }
                if (map.size() == i && atLeastK == i) {
                    result = Math.max(result, r - l);
                }
            }
        }
        return result;
    }

}
