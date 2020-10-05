package Y2020.linkedin.algo_part1;

import java.util.*;

public class Q027_Isomorphic_Words {

    public boolean isIsomorphic(String stra, String strb) {
        Map<Character, Integer> mapa = new HashMap<>();
        Map<Character, Integer> mapb = new HashMap<>();
        if (stra == null || strb == null) return false;
        if (stra.length() != strb.length()) return false;
        for (int i = 0; i < stra.length(); i++) {
            char ca = stra.charAt(i), cb = strb.charAt(i);
            if (mapa.containsKey(ca) != mapb.containsKey(cb)) return false;
            if (!mapa.containsKey(ca) && !mapb.containsKey(cb)) {
                mapa.put(ca, i);
                mapb.put(cb, i);
            } else {
                if (mapa.get(ca).intValue() != mapb.get(cb).intValue()) return false;
            }
        }
        return true;
    }

    public Set<Set<String>> isomorphicGroups(String[] words) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String word : words) {
            String key = hash(word);
            map.computeIfAbsent(key, k -> new HashSet<>()).add(word);
        }
        return new HashSet<>(map.values());
    }

    private String hash(String word) {
        if (word == null) return "";
        List<Integer> rslt = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!map.containsKey(c)) map.put(c, i);
            rslt.add(map.get(c));
        }
        return rslt.toString();
    }

}
