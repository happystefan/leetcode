package Y2019.Q0001_Q0300;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q0030_Substring_with_Concatenation_of_All_Words {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: sliding window
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public List<Integer> findSubstring_slidingWindow(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (words == null || words.length == 0) return result;
        Map<String, Integer> target = new HashMap<>();
        for (String word : words) target.put(word, target.getOrDefault(word, 0) + 1);
        int step = words[0].length();
        for (int i = 0; i < step; i++) {
            Map<String, Integer> window = new HashMap<>();
            int l = i, r = i, cnt = 0;
            while (r + step <= s.length()) {
                if (r - l + 1 <= words.length * step) {
                    String word = s.substring(r, r + step);
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    if (window.get(word).intValue() == target.getOrDefault(word, 0).intValue()) cnt++;
                    r += step;
                } else {
                    String word = s.substring(l, l + step);
                    if (window.get(word).intValue() == target.getOrDefault(word, 0).intValue()) cnt--;
                    window.put(word, window.getOrDefault(word, 0) - 1);
                    l += step;
                }
                if (cnt == target.size()) result.add(l);
            }
        }
        return result;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: sliding window version 2
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public List<Integer> findSubstring_slidingWindowV2(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (words == null || words.length == 0) return result;
        Map<String, Integer> target = new HashMap<>();
        for (String word : words) target.put(word, target.getOrDefault(word, 0) + 1);
        int step = words[0].length();
        for (int i = 0; i < step; i++) {
            Map<String, Integer> window = new HashMap<>();
            int l = i, r = i, cnt = 0;
            while (r + step <= s.length()) {
                if (r - l + 1 <= words.length * step) {
                    String word = s.substring(r, r + step);
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    if (window.get(word).intValue() == target.getOrDefault(word, 0).intValue()) cnt++;
                    r += step;
                }
                if (cnt == target.size()) result.add(l);
                if (r - l + 1 > words.length * step) {
                    String word = s.substring(l, l + step);
                    if (window.get(word).intValue() == target.getOrDefault(word, 0).intValue()) cnt--;
                    window.put(word, window.getOrDefault(word, 0) - 1);
                    l += step;
                }
            }
        }
        return result;
    }


}
