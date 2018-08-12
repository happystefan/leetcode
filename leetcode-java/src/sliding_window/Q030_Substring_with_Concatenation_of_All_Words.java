package sliding_window;

import java.util.*;

public class Q030_Substring_with_Concatenation_of_All_Words {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (words.length == 0) {
            return result;
        }
        Map<String, Integer> expected = new HashMap<>();
        for (String word : words) {
            expected.put(word, expected.getOrDefault(word, 0)+1);
        }
        int step = words[0].length();
        for (int i = 0; i < step; i++) {
            Map<String, Integer> appeared = new HashMap<>();
            int l = i, r = i;
            int count = 0;
            while (r+step <= s.length()) {
                String word = s.substring(r, r + step);
                if (r-l+1 <= step*words.length) {
                    r += step;
                    appeared.put(word, appeared.getOrDefault(word, 0)+1);
                    if (expected.getOrDefault(word, 0).intValue() == appeared.getOrDefault(word, 0).intValue()) {
                        count++;
                    }
                } else {
                    word = s.substring(l, l + step);
                    l += step;
                    if (expected.getOrDefault(word, 0).intValue() == appeared.getOrDefault(word, 0).intValue()) {
                        count--;
                    }
                    appeared.put(word, appeared.getOrDefault(word, 0)-1);
                }
                if (count == expected.size()) {
                    result.add(l);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

}
