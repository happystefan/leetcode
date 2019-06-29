package Y2018.sliding_window;

import java.util.LinkedList;
import java.util.List;

public class Q438_Find_All_Anagrams_in_a_String {

    public List<Integer> findAnagrams(String s, String p) {
        int[] target = new int[26];
        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }
        int[] histogram = new int[26];
        List<Integer> result = new LinkedList<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            histogram[ss[i] - 'a']++;
            if (i < p.length() - 1) {
                continue;
            }
            int l = i - p.length() + 1;
            if (isValid(histogram, target)) {
                result.add(l);
            }
            histogram[ss[l] - 'a']--;
        }
        return result;
    }

    private boolean isValid(int[] histogram, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (histogram[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

}
