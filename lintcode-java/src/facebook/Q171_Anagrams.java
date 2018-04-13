package facebook;

import java.util.*;

public class Q171_Anagrams {

    public List<String> anagrams(String[] strs) {
        Map<String, LinkedList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String root = new String(chars);
            map.computeIfAbsent(root, k -> new LinkedList<>());
            map.get(root).add(str);
        }
        List<String> result = new LinkedList<>();
        for (LinkedList<String> list : map.values()) {
            if (list.size() <= 1) {
                continue;
            }
            result.addAll(list);
        }
        return result;
    }

}
