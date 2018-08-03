package backtracking;

import java.util.*;

public class Q291_Word_Pattern_II {

    Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    public boolean wordPatternMatch(String pattern, String str) {
        return match(str, pattern,0, 0);
    }

    private boolean match(String str, String pattern, int i, int j) {
        if (i == str.length() && j == pattern.length()) return true;
        if (i == str.length() || j == pattern.length()) return false;
        char c = pattern.charAt(j);
        if (map.containsKey(c)) {
            String word = map.get(c);
            if (!str.startsWith(word, i)) {
                return false;
            }
            return match(str, pattern, i+word.length(), j+1);
        }
        for (int k = i; k < str.length(); k++) {
            String word = str.substring(i, k+1);
            if (set.contains(word)) {
                continue;
            }
            map.put(c, word);
            set.add(word);
            if (match(str, pattern, k+1, j+1)) {
                return true;
            }
            map.remove(c);
            set.remove(word);
        }
        return false;
    }

}
