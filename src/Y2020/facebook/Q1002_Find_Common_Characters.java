package Y2020.facebook;

import java.util.*;

public class Q1002_Find_Common_Characters {

    public List<String> commonChars(String[] A) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : A[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < A.length; i++) {
            String str = A[i];
            Map<Character, Integer> cur = new HashMap<>();
            for (char c : str.toCharArray()) {
                cur.put(c, cur.getOrDefault(c, 0) + 1);
            }
            Set<Character> set = cur.keySet();
            set.retainAll(map.keySet());
            Map<Character, Integer> newMap = new HashMap<>();
            for (char c : set) {
                newMap.put(c, Math.min(map.get(c), cur.get(c)));
            }
            map = newMap;
        }
        List<String> rslt = new LinkedList<>();
        for (char c : map.keySet()) {
            for (int i = 0; i < map.get(c); i++) rslt.add("" + c);
        }
        return rslt;
    }

}
