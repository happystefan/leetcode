package Y2020.linkedin.algo_part1;

import java.util.Arrays;

public class Q043_Minimum_Number_of_Coins {

    public int minNumOfCoins(int[] vals, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int v : vals) {
                if (v <= i) {
                    dp[i] = Math.min(dp[i], dp[i - v] + 1);
                }
            }
        }
        return dp[sum];
    }

}
