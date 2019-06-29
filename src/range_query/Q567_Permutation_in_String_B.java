package range_query;

import java.util.HashMap;
import java.util.Map;

public class Q567_Permutation_in_String_B {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> appear = new HashMap<>();
        char[] ss = s2.toCharArray();
        for (char c : s1.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        int cnt = 0;
        for (r = 0; r < s2.length(); r++) {
            if (!target.containsKey(ss[r])) {
                appear.clear();
                continue;
            }
            if (cnt < s1.length() && r < s2.length()) {
                appear.put(ss[r], appear.getOrDefault(ss[r], 0) + 1);
                if (appear.get(ss[r]) <= target.get(ss[r])) {
                    cnt++;
                }
                r++;
            } else {
                appear.put(ss[l], appear.get(ss[l]) - 1);
                if (appear.get(ss[l]) < target.get(ss[l])) {
                    cnt--;
                }
                l++;
            }
            if (cnt == s1.length()) {
                return true;
            }
        }
        return false;
    }

}
