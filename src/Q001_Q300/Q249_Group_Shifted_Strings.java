package Q001_Q300;

import java.util.*;

public class Q249_Group_Shifted_Strings {

    public List<List<String>> groupStrings(String[] strings) {
        Arrays.sort(strings);
        Map<String, LinkedList<String>> map = new HashMap<>();
        for (String str : strings) {
            boolean found = false;
            for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
                if (isShiftedStrings(entry.getKey(), str)) {
                    LinkedList<String> list = entry.getValue();
                    list.add(str);
                    map.put(entry.getKey(), list);
                    found = true;
                    break;
                }
            }
            if (!found) map.put(str, new LinkedList<>());
        }

        List<List<String>> ans = new LinkedList<>();
        for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
            LinkedList<String> list = new LinkedList<>();
            list.add(entry.getKey());
            list.addAll(entry.getValue());
            ans.add(list);
        }
        return ans;
    }

    public boolean isShiftedStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int dis = charDis(s1.charAt(0), s2.charAt(0));
        for (int i = 1; i < s1.length(); i++) {
            if (dis != charDis(s1.charAt(i), s2.charAt(i))) return false;
        }
        return true;
    }

    public int charDis(char c1, char c2) {
        return c1 < c2 ? c2 - c1 : c2 + 26 - c1;
    }

}
