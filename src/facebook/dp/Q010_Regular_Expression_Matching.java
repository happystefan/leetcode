package facebook.dp;

public class Q010_Regular_Expression_Matching {

    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray(), pp = p.toCharArray();
        boolean[][] dp = new boolean[ss.length + 1][pp.length + 1];
        dp[0][0] = true;
        for (int j = 0; j < pp.length; j++) {
            if (pp[j] == '*') {
                dp[0][j + 1] |= dp[0][j - 1];
            }
        }
        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j < pp.length; j++) {
                if (ss[i] == pp[j] || pp[j] == '.') {
                    dp[i + 1][j + 1] |= dp[i][j];
                }
                if (pp[j] == '*') {
                    if (ss[i] != pp[j - 1] && pp[j - 1] != '.') {
                        dp[i + 1][j + 1] |= dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] |= (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[ss.length][pp.length];
    }

}
