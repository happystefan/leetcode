package facebook;

import java.util.*;

public class Q791_Custom_Sort_String {

    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : T.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (!map.containsKey(c)) {
                continue;
            }
            int cnt = map.get(c);
            while (cnt-- > 0) {
                sb.append(c);
            }
            map.remove(c);
        }
        for (char c : map.keySet()) {
            int cnt = map.get(c);
            while (cnt-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
