package Y2020.facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q0438_Find_All_Anagrams_in_a_String {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> appear = new HashMap<>();
        for (char c : p.toCharArray()) target.put(c, target.getOrDefault(c, 0) + 1);
        List<Integer> rslt = new LinkedList<>();
        int l = 0, r = 0;
        int cnt = 0;
        char[] ss = s.toCharArray();
        while (r < ss.length) {
            appear.put(ss[r], appear.getOrDefault(ss[r], 0) + 1);
            if (appear.get(ss[r]).intValue() == target.getOrDefault(ss[r], 0).intValue()) cnt++;
            r++;
            if (cnt == target.size()) rslt.add(l);
            if (r - l >= p.length()) {
                if (appear.get(ss[l]).intValue() == target.getOrDefault(ss[l], 0).intValue()) cnt--;
                appear.put(ss[l], appear.get(ss[l]) - 1);
                l++;
            }
        }
        return rslt;
    }

}
