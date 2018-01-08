package google;

import java.util.HashMap;
import java.util.Map;

public class Q340_Longest_Substring_with_At_Most_K_Distinct_Characters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.isEmpty() || k <= 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int ans = 0;
        for (int h = 0; h < s.length(); h++) {
            if (map.size() <= k) map.put(s.charAt(h), h);
            int ll = Integer.MAX_VALUE;
            if (map.size() > k) {
                for (int j : map.values()) {
                    ll = Math.min(j, ll);
                }
                map.remove(s.charAt(ll));
                l = ll+1;
            }
            ans = Math.max(ans, h-l+1);
        }
        return ans;
    }

}
