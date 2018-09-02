package facebook;

import java.util.*;

public class Q049_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ss = str.toCharArray();
            Arrays.sort(ss);
            String key = new String(ss);
            map.computeIfAbsent(key, k -> new LinkedList<>()).add(str);
        }
        return new LinkedList<>(map.values());
    }

}
