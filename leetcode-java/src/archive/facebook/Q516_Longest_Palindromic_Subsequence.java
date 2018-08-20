package archive.facebook;

public class Q516_Longest_Palindromic_Subsequence {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int dp[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i+1 < len) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    dp[i][i+1] = 2;
                } else {
                    dp[i][i+1] = 1;
                }
            }
        }
        for (int l = 2; l < len; l++) {
            for (int i = 0; i+l < len; i++) {
                int j = i+l;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1]+2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }

}
