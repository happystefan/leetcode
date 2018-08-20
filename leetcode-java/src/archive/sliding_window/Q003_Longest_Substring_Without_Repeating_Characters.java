package archive.sliding_window;

public class Q003_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];
        int l = 0, r = 0;
        int result = 0;
        char[] ss = s.toCharArray();
        while (r < s.length()) {
            if (cnt[ss[r++]]++ == 0) {
                result = Math.max(result, r-l);
            }
            while (cnt[ss[r-1]] > 1) {
                cnt[ss[l++]]--;
            }
        }
        return result;
    }

}
