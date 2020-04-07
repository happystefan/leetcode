package Y2020.facebook;

import java.util.*;

public class Q0030_Substring_with_Concatenation_of_All_Words {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rslt = new LinkedList<>();
        if (words.length == 0) return rslt;

        Map<String, Integer> target = new HashMap<>();
        for (String word : words) target.put(word, target.getOrDefault(word, 0) + 1);

        int step = words[0].length();
        for (int i = 0; i < step; i++) {
            Map<String, Integer> window = new HashMap<>();
            int l = i, r = i, cnt = 0;
            while (r + step <= s.length()) {
                String word = s.substring(r, r + step);
                if (r - l + 1 <= words.length * step) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    if (window.get(word).intValue() == target.getOrDefault(word, 0).intValue()) cnt++;
                    r += step;
                    if (cnt == target.size()) rslt.add(l);
                } else {
                    word = s.substring(l, l + step);
                    if (window.get(word).intValue() == target.getOrDefault(word, 0).intValue()) cnt--;
                    window.put(word, window.getOrDefault(word, 0) - 1);
                    l += step;
                }
            }
        }
        Collections.sort(rslt);
        return rslt;
    }

}
