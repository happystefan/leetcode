package Y2020.facebook.misc;

import java.util.HashMap;
import java.util.Map;

public class Q0953_Verifying_an_Alien_Dictionary {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String worda = words[i - 1], wordb = words[i];
            if (worda.equals(wordb)) continue;
            if (wordb.startsWith(worda)) continue;
            if (worda.startsWith(wordb)) return false;
            int j = 0;
            while (j < worda.length() && j < wordb.length() && worda.charAt(j) == wordb.charAt(j)) j++;
            if (map.get(worda.charAt(j)) > map.get(wordb.charAt(j))) return false;
        }
        return true;
    }

}
