package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0340_Longest_Substring_with_At_Most_K_Distinct_Characters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] ss = s.toCharArray();
        int l = 0, r = 0, rslt = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < ss.length) {
            map.put(ss[r], map.getOrDefault(ss[r], 0) + 1);
            r++;
            while (map.size() > k) {
                map.put(ss[l], map.get(ss[l]) - 1);
                if (map.get(ss[l]) == 0) map.remove(ss[l]);
                l++;
            }
            rslt = Math.max(rslt, r - l);
        }
        return rslt;
    }

}
