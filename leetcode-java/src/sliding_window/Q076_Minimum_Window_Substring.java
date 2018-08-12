package sliding_window;

public class Q076_Minimum_Window_Substring {

    public String minWindow(String s, String t) {
        int[] target = new int[128];
        for (char c : t.toCharArray()) {
            target[c]++;
        }
        char[] ss = s.toCharArray();
        int l = 0, r = 0, count = t.length();
        int len = Integer.MAX_VALUE, start = 0;
        while (r < s.length()) {
            if (target[ss[r++]]-- > 0) count--;
            while (count == 0) {
                if (r-l < len) {
                    len = r-l;
                    start = l;
                }
                if (target[ss[l++]]++ == 0) count++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }

}
