package facebook.sliding_window;

import java.util.*;

public class Q030_Substring_with_Concatenation_of_All_Words {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (words == null || words.length == 0) return result;
        Map<String, Integer> target = new HashMap<>();
        for (String word : words) target.put(word, target.getOrDefault(word, 0)+1);
        int step = words[0].length();
        for (int i = 0; i < step; i++) {
            Map<String, Integer> appear = new HashMap<>();
            int l = i, r = i, cnt = 0;
            while (r+step <= s.length()) {
                if (r-l+1 <= words.length*step) {
                    String word = s.substring(r, r + step);
                    appear.put(word, appear.getOrDefault(word, 0) + 1);
                    if (appear.get(word).intValue() == target.getOrDefault(word, 0).intValue()) cnt++;
                    r += step;
                    if (cnt == target.size()) result.add(l);
                } else {
                    String word = s.substring(l, l + step);
                    if (appear.get(word).intValue() == target.getOrDefault(word, 0).intValue()) cnt--;
                    appear.put(word, appear.getOrDefault(word, 0) - 1);
                    l += step;
                }
            }
        }
        return result;
    }

}
