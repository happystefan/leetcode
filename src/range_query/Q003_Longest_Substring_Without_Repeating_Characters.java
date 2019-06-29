package range_query;

import java.util.HashSet;
import java.util.Set;

public class Q003_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        int n = s.length();
        int l = 0, r = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        while (r < n) {
            while (set.contains(ss[r])) {
                set.remove(ss[l]);
                l++;
            }
            set.add(ss[r]);
            r++;
            result = Math.max(result, r - l);
        }
        return result;
    }

}
