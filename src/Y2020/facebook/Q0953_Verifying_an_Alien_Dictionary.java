package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0953_Verifying_an_Alien_Dictionary {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i], b = words[i + 1];
            if (a.startsWith(b) && a.length() > b.length()) return false;
            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                char cha = a.charAt(j), chb = b.charAt(j);
                if (!map.containsKey(cha) || !map.containsKey(chb)) continue;
                if (map.get(cha) < map.get(chb)) break;
                if (map.get(cha) > map.get(chb)) return false;
            }
        }
        return true;
    }

}
