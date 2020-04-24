package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0424_Longest_Repeating_Character_Replacement {

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] ss = s.toCharArray();
        int l = 0, r = 0, rslt = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < ss.length) {
            map.put(ss[r], map.getOrDefault(ss[r], 0) + 1);
            max = Math.max(max, map.get(ss[r]));
            r++;
            if (r - l - max > k) {
                map.put(ss[l], map.get(ss[l]) - 1);
                l++;
            }
            rslt = Math.max(rslt, r - l + 1);
        }
        return rslt;
    }

}
