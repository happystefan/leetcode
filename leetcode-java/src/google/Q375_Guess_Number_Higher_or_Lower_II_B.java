package google;

public class Q375_Guess_Number_Higher_or_Lower_II_B {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int l = 1; l < n; l++) {
            for (int i = 1; i+l <= n; i++) {
                dp[i][i+l] = Integer.MAX_VALUE;
                for (int k = i; k <= i+l; k++)
                    dp[i][i+l] = Math.min(dp[i][i+l], k+Math.max(dp[i][k-1], dp[k+1][i+l]));
            }
        }
        return dp[1][n];
    }

}
