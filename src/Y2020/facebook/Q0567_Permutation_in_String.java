package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0567_Permutation_in_String {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> appear = new HashMap<>();
        for (char c : s1.toCharArray()) target.put(c, target.getOrDefault(c, 0) + 1);
        int l = 0, r = 0;
        int cnt = 0;
        char[] ss = s2.toCharArray();
        while (r < ss.length) {
            appear.put(ss[r], appear.getOrDefault(ss[r], 0) + 1);
            if (appear.get(ss[r]).intValue() == target.getOrDefault(ss[r], 0).intValue()) cnt++;
            r++;
            if (cnt == target.size()) return true;
            if (r - l >= s1.length()) {
                if (appear.get(ss[l]).intValue() == target.getOrDefault(ss[l], 0).intValue()) cnt--;
                appear.put(ss[l], appear.get(ss[l]) - 1);
                l++;
            }
        }
        return false;
    }

}
