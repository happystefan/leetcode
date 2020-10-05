package Y2020.linkedin.algo_part2;

import java.util.Arrays;

public class Q004_Color_Assignment_RGB_Bakery {

    public int paintCakes(int[][] costs) {
        int numCake = costs.length;
        int numColor = costs[0].length;
        int[][] dp = new int[numCake + 1][numColor];
        for (int i = 1; i <= numCake; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= numCake; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[numCake][0], Math.min(dp[numCake][1], dp[numCake][2]));
    }

}
