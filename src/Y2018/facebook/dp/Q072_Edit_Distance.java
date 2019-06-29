package Y2018.facebook.dp;

public class Q072_Edit_Distance {

    public int minDistance(String word1, String word2) {
        char[] ss1 = word1.toCharArray(), ss2 = word2.toCharArray();
        int m = ss1.length, n = ss2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (ss1[i - 1] == ss2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }

}
