package Y2020.facebook;

import java.util.HashSet;
import java.util.Set;

public class Q0003_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, rslt = 0;
        while (r < ss.length) {
            while (set.contains(ss[r])) set.remove(ss[l++]);
            set.add(ss[r++]);
            rslt = Math.max(rslt, r - l);
        }
        return rslt;
    }

}
