package Y2019.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0953_Verifying_an_Alien_Dictionary {

    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) return true;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) map.put(order.charAt(i), i);
        for (int i = 1; i < words.length; i++) {
            if (!isSorted(words[i - 1], words[i], map)) return false;
        }
        return true;
    }

    private boolean isSorted(String a, String b, Map<Character, Integer> map) {
        if (a.equals(b)) return true;
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            int ai = map.get(a.charAt(i)), bi = map.get(b.charAt(i));
            if (ai == bi) continue;
            if (ai < bi) return true;
            else return false;
        }
        return a.length() < b.length();
    }

}
