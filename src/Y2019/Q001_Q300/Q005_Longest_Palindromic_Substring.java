package Y2019.Q001_Q300;

public class Q005_Longest_Palindromic_Substring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String result = s.substring(0, 1);
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                dp[i - 1][i] = true;
                result = s.substring(i - 1, i + 1);
            }
        }
        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (j - i + 1 > result.length()) result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

}
