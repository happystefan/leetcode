package range_query;

import java.util.HashMap;
import java.util.Map;

public class Q159_Longest_Substring_with_At_Most_Two_Distinct_Characters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int counts = 0;
        int result = 0;
        while (l < s.length()) {
            if (counts <= 2 && r < s.length()) {
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
                if (map.get(s.charAt(r)) == 1) {
                    counts++;
                }
                r++;
            } else {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) {
                    counts--;
                }
                l++;
            }
            if (counts <= 2) {
                result = Math.max(result, r - l);
            }
        }
        return result;
    }

}
