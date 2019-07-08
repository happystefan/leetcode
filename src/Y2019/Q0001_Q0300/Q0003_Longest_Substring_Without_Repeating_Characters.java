package Y2019.Q0001_Q0300;

import java.util.HashSet;
import java.util.Set;

public class Q0003_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        while (r < ss.length) {
            while (set.contains(ss[r])) {
                set.remove(ss[l++]);
            }
            set.add(ss[r++]);
            result = Math.max(result, r - l);
        }
        return result;
    }

}
