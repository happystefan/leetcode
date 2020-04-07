package Y2020.facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q0249_Group_Shifted_Strings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            map.computeIfAbsent(root(str), k -> new LinkedList<>()).add(str);
        }
        return new LinkedList<>(map.values());
    }

    private String root(String str) {
        if (str == null || str.length() == 0) return str;
        char[] ss = str.toCharArray();
        int diff = ss[0] - 'a';
        for (int i = 0; i < ss.length; i++) {
            ss[i] -= diff;
            if (ss[i] < 'a') ss[i] += 26;
        }
        return new String(ss);
    }

}
