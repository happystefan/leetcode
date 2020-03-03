package Y2020.facebook;

import java.util.*;

public class Q0451_Sort_Characters_By_Frequency {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        List<Character> ss = new LinkedList<>(map.keySet());
        Collections.sort(ss, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for (char c : ss) {
            for (int i = 0; i < map.get(c); i++) sb.append(c);
        }
        return sb.toString();
    }

}
