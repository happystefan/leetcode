package sliding_window;

import java.util.*;

public class Q159_Longest_Substring_with_At_Most_Two_Distinct_Characters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] ss = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int result = 0;
        while (r < ss.length) {
            if (map.size() > 2) {
                map.put(ss[l], map.get(ss[l])-1);
                if (map.get(ss[l]) == 0) {
                    map.remove(ss[l]);
                }
                l++;
            } else {
                map.put(ss[r], map.getOrDefault(ss[r], 0)+1);
                r++;
            }
            if (map.size() <= 2) {
                result = Math.max(result, r-l);
            }
        }
        return result;
    }

}
