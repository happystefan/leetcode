package Y2018.facebook.dp;

public class Q740_Delete_and_Earn {

    public int deleteAndEarn(int[] nums) {
        int n = 10000;
        int[] cnts = new int[n + 1];
        for (int num : nums) cnts[num]++;
        int[] dp = new int[n + 1];
        dp[1] = cnts[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * cnts[i]);
        }
        return dp[n];
    }

}
