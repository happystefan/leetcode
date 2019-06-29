package facebook;

public class Q005_Longest_Palindromic_Substring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        int max_len = 1;
        String result = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                max_len = 2;
                result = s.substring(i, i + 2);
            }
        }
        for (int l = 2; l < len; l++) {
            for (int i = 0; i + l < len; i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;

                    if (j - i + 1 > max_len) {
                        max_len = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }

}
