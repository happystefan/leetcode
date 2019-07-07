package Y2019.Q0001_Q0300;

public class Q0044_Wildcard_Matching {

    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int m = ss.length, n = pp.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (pp[j - 1] == '*') dp[0][j] |= dp[0][j - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (ss[i - 1] == pp[j - 1] || pp[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (pp[j - 1] == '*') dp[i][j] = dp[i][j - 1] | dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

}
