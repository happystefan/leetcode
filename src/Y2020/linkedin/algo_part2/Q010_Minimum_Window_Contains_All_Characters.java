package Y2020.linkedin.algo_part2;

import java.util.HashMap;
import java.util.Map;

public class Q010_Minimum_Window_Contains_All_Characters {

    // Time Complexity : O(|S| + |T|)O(∣S∣+∣T∣) where |S| and |T| represent the lengths of
    // strings SS and TT
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> appear = new HashMap<>();
        for (char c : t.toCharArray()) target.put(c, target.getOrDefault(c, 0) + 1);
        String result = "";
        int l = 0, r = 0, cnt = 0;
        while (r < ss.length) {
            appear.put(ss[r], appear.getOrDefault(ss[r], 0) + 1);
            if (appear.get(ss[r]).intValue() == target.getOrDefault(ss[r], 0).intValue()) cnt++;
            r++;

            while (cnt == target.size()) {
                if (result.equals("") || result.length() > r - l) {
                    result = s.substring(l, r);
                }
                if (appear.get(ss[l]).intValue() == target.getOrDefault(ss[l], 0).intValue()) cnt--;
                appear.put(ss[l], appear.get(ss[l]) - 1);
                l++;
            }
        }
        return result;
    }

}
