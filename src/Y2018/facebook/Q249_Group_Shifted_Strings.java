package Y2018.facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q249_Group_Shifted_Strings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String key = hash(str);
            map.computeIfAbsent(key, k -> new LinkedList<>());
            map.get(key).add(str);
        }
        return new LinkedList<>(map.values());
    }

    private String hash(String str) {
        if (str.length() == 1) {
            return "a";
        }
        char[] ss = str.toCharArray();
        int offset = ss[0] - 'a';
        for (int i = 0; i < ss.length; i++) {
            ss[i] = (char) ('a' + (ss[i] - 'a' - offset + 26) % 26);
        }
        return new String(ss);
    }

}
