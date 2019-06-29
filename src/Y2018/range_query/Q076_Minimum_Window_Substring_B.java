package Y2018.range_query;

import java.util.HashMap;
import java.util.Map;

public class Q076_Minimum_Window_Substring_B {

    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> appear = new HashMap<>();
        char[] ss = s.toCharArray();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int cnt = 0, l = 0, r = 0;
        int min_len = Integer.MAX_VALUE, min_idx = 0;
        for (r = 0; r < s.length(); r++) {
            if (!target.containsKey(ss[r])) {
                continue;
            }
            appear.put(ss[r], appear.getOrDefault(ss[r], 0) + 1);
            if (appear.get(ss[r]) <= target.get(ss[r])) {
                cnt++;
            }
            if (cnt == t.length()) {
                while (!target.containsKey(ss[l]) || target.get(ss[l]) < appear.get(ss[l])) {
                    if (target.containsKey(ss[l]) && appear.get(ss[l]) > target.get(ss[l])) {
                        appear.put(ss[l], appear.get(ss[l]) - 1);
                    }
                    l++;
                }
                if (r - l + 1 < min_len) {
                    min_idx = l;
                    min_len = r - l + 1;
                }
            }
        }
        return min_len == Integer.MAX_VALUE ? "" : s.substring(min_idx, min_idx + min_len);
    }

}
