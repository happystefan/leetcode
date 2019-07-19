package Y2019.Q0001_Q0300;

import java.util.HashMap;
import java.util.Map;

public class Q0076_Minimum_Window_Substring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) target.put(c, target.getOrDefault(c, 0) + 1);
        char[] ss = s.toCharArray();
        String result = "";
        int l = 0, r = 0, cnt = 0;

        while (r < ss.length) {
            if (cnt < target.size()) {
                window.put(ss[r], window.getOrDefault(ss[r], 0) + 1);
                if (target.containsKey(ss[r]) && window.get(ss[r]).intValue() == target.get(ss[r]).intValue()) cnt++;
                r++;
            }
            while (cnt == target.size()) {
                if (result.equals("") || result.length() > (r - l)) result = s.substring(l, r);
                if (target.containsKey(ss[l]) && window.get(ss[l]).intValue() == target.get(ss[l]).intValue()) cnt--;
                window.put(ss[l], window.get(ss[l]) - 1);
                l++;
            }
        }
        return result;
    }

}
