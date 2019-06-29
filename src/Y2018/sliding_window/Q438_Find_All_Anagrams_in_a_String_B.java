package Y2018.sliding_window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q438_Find_All_Anagrams_in_a_String_B {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> expected = new HashMap<>();
        Map<Character, Integer> appeared = new HashMap<>();
        for (char c : p.toCharArray()) {
            expected.put(c, expected.getOrDefault(c, 0) + 1);
        }
        List<Integer> result = new LinkedList<>();
        char[] ss = s.toCharArray();
        int satisfied = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            if (r - l + 1 <= p.length()) {
                appeared.put(ss[r], appeared.getOrDefault(ss[r], 0) + 1);
                if (appeared.get(ss[r]).intValue() == expected.getOrDefault(ss[r], 0).intValue()) {
                    satisfied++;
                }
                r++;
            } else { // (r-l+1 > p.length()
                if (appeared.get(ss[l]).intValue() == expected.getOrDefault(ss[l], 0).intValue()) {
                    satisfied--;
                }
                appeared.put(ss[l], appeared.getOrDefault(ss[l], 0) - 1);
                l++;
            }
            if (satisfied == expected.size()) {
                result.add(l);
            }
        }
        return result;
    }

}
