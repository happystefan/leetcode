package archive.range_query;

import java.util.*;

public class Q076_Minimum_Window_Substring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        while (r < s.length() && !isValid(map, target)) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            r++;
        }
        if (r >= s.length() && !isValid(map, target)) {
            return "";
        }
        String result = s.substring(l, r);

        while (l < s.length()) {
            boolean flag = false;
            while (isValid(map, target) && map.get(s.charAt(l)) > target.getOrDefault(s.charAt(l), 0)) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
                flag = true;
                if (r - l < result.length()) {
                    result = s.substring(l, r);
                }
            }
            if (!flag && r >= s.length()) {
                break;
            }
            if (r < s.length()) {
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
                r++;
            }
        }

        return result;
    }

    private boolean isValid(Map<Character, Integer> a, Map<Character, Integer> b) {
        if (a.size() < b.size()) {
            return false;
        }
        for (char c : b.keySet()) {
            if (!a.containsKey(c) || a.get(c) < b.get(c)) {
                return false;
            }
        }
        return true;
    }

}
