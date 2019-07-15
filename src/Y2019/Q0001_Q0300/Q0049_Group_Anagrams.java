package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0049_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ss = str.toCharArray();
            Arrays.sort(ss);
            String root = new String(ss);
            map.computeIfAbsent(root, k -> new LinkedList<>());
            map.get(root).add(str);
        }
        return new LinkedList<>(map.values());
    }

}
