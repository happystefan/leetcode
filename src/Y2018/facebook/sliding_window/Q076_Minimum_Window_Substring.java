package Y2018.facebook.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Q076_Minimum_Window_Substring {

    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> appear = new HashMap<>();
        for (char c : t.toCharArray()) target.put(c, target.getOrDefault(c, 0) + 1);
        String result = "";
        int l = 0, r = 0, cnt = 0;
        while (r < ss.length) {
            appear.put(ss[r], appear.getOrDefault(ss[r], 0) + 1);
            if (appear.get(ss[r]).intValue() == target.getOrDefault(ss[r], 0).intValue()) cnt++;
            r++;

            while (cnt == target.size()) {
                if (result.equals("") || result.length() > r - l) {
                    result = s.substring(l, r);
                }
                if (appear.get(ss[l]).intValue() == target.getOrDefault(ss[l], 0).intValue()) cnt--;
                appear.put(ss[l], appear.get(ss[l]) - 1);
                l++;
            }
        }
        return result;
    }

}
