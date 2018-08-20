package archive.facebook;

public class Q044_Wildcard_Matching {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] ss = s.toCharArray(), pp = p.toCharArray();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = ss[i-1] == pp[j-1] && dp[i-1][j-1] ||
                        pp[j-1] == '?' && dp[i-1][j-1] ||
                        (pp[j-1] == '*' && (dp[i-1][j] || dp[i][j-1] || dp[i-1][j-1]));
            }
        }
        return dp[m][n];
    }

}
