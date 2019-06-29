package Y2018.Q001_Q300;

/**
 * Created by mqliang on 5/27/17.
 */
public class Q005_Longest_Palindromic_Substring {
    int max = 0;
    String ans = "";

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            gao(s, i, i);
            gao(s, i, i + 1);
        }
        return ans;
    }

    public void gao(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                return;
            }
            if (r - l + 1 > max) {
                max = r - l + 1;
                ans = s.substring(l, r + 1);
            }
            l--;
            r++;
        }
    }
}
