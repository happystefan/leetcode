package archive.dp;

import java.util.*;

public class Q265_Paint_House_II {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length, m = costs[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = costs[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (k == j) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k]+costs[i][j]);
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
