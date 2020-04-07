package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0076_Minimum_Window_Substring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) target.put(c, target.getOrDefault(c, 0) + 1);
        int l = 0, r = 0, cnt = 0;
        char[] ss = s.toCharArray();
        String rslt = "";
        while (r < ss.length) {
            window.put(ss[r], window.getOrDefault(ss[r], 0) + 1);
            if (window.get(ss[r]).intValue() == target.getOrDefault(ss[r], 0).intValue()) cnt++;
            r++;
            while (cnt == target.size()) {
                if (rslt.equals("") || r - l < rslt.length()) rslt = s.substring(l, r);
                if (window.get(ss[l]).intValue() == target.getOrDefault(ss[l], 0)) cnt--;
                window.put(ss[l], window.get(ss[l]) - 1);
                l++;
            }
        }
        return rslt;
    }

}
