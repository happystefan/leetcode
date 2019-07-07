package Y2019.Q0001_Q0300;

public class Q0010_Regular_Expression_Matching {

    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j < n; j++) {
            if (pp[j] == '*') {
                dp[0][j + 1] |= dp[0][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ss[i] == pp[j] || pp[j] == '.') dp[i + 1][j + 1] |= dp[i][j];
                if (pp[j] == '*') {
                    if (ss[i] == pp[j - 1] || pp[j - 1] == '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j] | dp[i][j + 1] | dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

}
