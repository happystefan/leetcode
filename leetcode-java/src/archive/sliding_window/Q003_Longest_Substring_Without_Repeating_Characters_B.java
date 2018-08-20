package archive.sliding_window;

import java.util.*;

public class Q003_Longest_Substring_Without_Repeating_Characters_B {

    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int result = 0;
        while (r < ss.length) {
            while (set.contains(ss[r])) {
                set.remove(ss[l++]);
            }
            set.add(ss[r++]);
            result = Integer.max(result, r-l);
        }
        return result;
    }

}
