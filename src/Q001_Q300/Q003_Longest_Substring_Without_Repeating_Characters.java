package Q001_Q300;

import java.util.HashMap;

/**
 * Created by mqliang on 5/27/17.
 */
public class Q003_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }
            map.put(s.charAt(r), r);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
