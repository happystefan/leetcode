package archive.google;

import java.util.LinkedHashMap;

public class Q340_Longest_Substring_with_At_Most_K_Distinct_Characters_B {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.isEmpty() || k <= 0) return 0;
        int l = 0, ans = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int h = 0; h < s.length(); h++) {
            char c = s.charAt(h);
            if (map.containsKey(c)) map.remove(c);
            map.put(c, h);
            if (map.size() > k) {
                char key = map.keySet().iterator().next();
                l = map.get(key)+1;
                map.remove(key);
            }
            ans = Math.max(ans, h-l+1);
        }
        return ans;
    }

}


