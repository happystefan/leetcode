package Y2018.facebook.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Q395_Longest_Substring_with_At_Least_K_Repeating_Characters {

    public int longestSubstring(String s, int k) {
        char[] ss = s.toCharArray();
        int result = 0;
        for (int i = 1; i <= 26; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int l = 0, r = 0;
            int cnt = 0; // number of characters repeating at least k
            while (r < ss.length) {
                map.put(ss[r], map.getOrDefault(ss[r], 0) + 1);
                if (map.get(ss[r]) == k) cnt++;
                r++;

                while (map.size() > i) {
                    if (map.get(ss[l]) == k) cnt--;
                    map.put(ss[l], map.get(ss[l]) - 1);
                    if (map.get(ss[l]) == 0) map.remove(ss[l]);
                    l++;
                }
                if (map.size() == i && cnt == i) result = Math.max(result, r - l);
            }
        }
        return result;
    }

}
