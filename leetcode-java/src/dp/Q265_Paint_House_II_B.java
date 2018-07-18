package dp;

import java.util.*;

public class Q265_Paint_House_II_B {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length, m = costs[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int min1 = -1, min2 = -1;
        for (int j = 0; j < m; j++) {
            dp[0][j] = costs[0][j];
            if (min1 == -1 || dp[0][j] < dp[0][min1]) {
                min2 = min1;
                min1 = j;
            } else if (min2 == -1 || dp[0][j] < dp[0][min2]){
                min2 = j;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = costs[i][j] + (j == min1 ? dp[i - 1][min2] : dp[i - 1][min1]);
            }
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < m; j++) {
                if (min1 == -1 || dp[i][j] < dp[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 == -1 || dp[i][j] < dp[i][min2]){
                    min2 = j;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            result = Math.min(result, dp[n-1][j]);
        }
        return result;
    }

}
