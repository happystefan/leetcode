package Y2018.google;

import java.util.*;

public class Q527_Word_Abbreviation {

    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : dict) {
            String key = abbrev(word, 0);
            map.computeIfAbsent(key, k -> new LinkedList<>());
            map.get(key).add(word);
        }
        Map<String, String> memo = new HashMap<>();
        for (String abbr : map.keySet()) {
            List<String> group = map.get(abbr);
            if (group.size() == 1) {
                memo.put(group.get(0), abbr);
                continue;
            }
            Collections.sort(group);
            int[] lcp = new int[group.size()];
            for (int i = 1; i < group.size(); ++i) {
                int p = longestCommonPrefix(group.get(i - 1), group.get(i));
                lcp[i] = p;
                lcp[i - 1] = Math.max(lcp[i - 1], p);
            }
            for (int i = 0; i < group.size(); i++) {
                memo.put(group.get(i), abbrev(group.get(i), lcp[i]));
            }
        }

        List<String> result = new LinkedList<>();
        for (String word : dict) {
            result.add(memo.get(word));
        }
        return result;
    }

    private int longestCommonPrefix(String a, String b) {
        int i = 0;
        while (a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return i;
    }

    private String abbrev(String word, int i) {
        int len = word.length();
        if (len - i <= 3) return word;
        return word.substring(0, i + 1) + (len - i - 2) + word.charAt(len - 1);
    }

}
