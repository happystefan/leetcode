package Y2018.dp;

public class Q740_Delete_and_Earn_B {

    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        for (int num : nums) {
            dp[num] += num;
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        }
        return dp[dp.length - 1];
    }

}
