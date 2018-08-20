package archive.sliding_window;

import java.util.*;

public class Q438_Find_All_Anagrams_in_a_String_C {

    public List<Integer> findAnagrams(String s, String p) {
        int[] target = new int[128];
        for (char c : p.toCharArray()) {
            target[c]++;
        }
        char[] ss = s.toCharArray();
        int l = 0, r = 0, count = p.length();
        List<Integer> result = new LinkedList<>();
        while (r < s.length()) {
            if (target[ss[r++]]-- > 0) count--;
            while (count == 0) {
                if (r-l == p.length()) {
                    result.add(l);
                }
                if (target[ss[l++]]++ == 0) count++;
            }
        }
        return result;
    }

}
