package Y2018.facebook;

public class Q010_Regular_Expression_Matching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] ss = s.toCharArray(), pp = p.toCharArray();
        int m = ss.length, n = pp.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 0; j < n; j++) {
            if (pp[j] == '*') {
                dp[0][j + 1] |= j > 0 && dp[0][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ss[i] == pp[j] || pp[j] == '.') {
                    dp[i + 1][j + 1] |= dp[i][j];
                }
                if (pp[j] == '*') {
                    if (j > 0 && ss[i] != pp[j - 1] && pp[j - 1] != '.') {
                        dp[i + 1][j + 1] |= dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || j > 1 && dp[i + 1][j - 1]);
                    }
                }

            }
        }
        return dp[m][n];
    }

}
