package Y2018.facebook;

import java.util.*;

public class Q049_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = hash(str);
            map.computeIfAbsent(key, k -> new LinkedList<>());
            map.get(key).add(str);
        }
        return new LinkedList<>(map.values());
    }

    private String hash(String str) {
        char[] ss = str.toCharArray();
        Arrays.sort(ss);
        return new String(ss);
    }

}
