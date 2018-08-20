package archive.sliding_window;

public class Q424_Longest_Repeating_Character_Replacement {

    public int characterReplacement(String s, int k) {
        char[] ss = s.toCharArray();
        int[] cnt = new int[128];
        int l = 0, r = 0;
        int result = 0, max_cnt = 0;
        while (r < ss.length) {
            cnt[ss[r]] += 1;
            max_cnt = Math.max(max_cnt, cnt[ss[r]]);
            while (r-l+1-max_cnt > k) {
                cnt[ss[l++]] -= 1;
            }
            result = Math.max(result, r-l+1);
            r++;
        }
        return result;
    }

}
