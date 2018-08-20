package archive.divide_and_conquer;

public class Q312_Burst_Balloons_B {

    // DP: bottom up
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length+2];
        balloons[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            balloons[i+1] = nums[i];
        }
        balloons[balloons.length-1] = 1;
        int[][] dp = new int[balloons.length][balloons.length];
        for (int w = 2; w < balloons.length; w++) {
            for (int l = 0; l+w < balloons.length; l++) {
                int r = l+w;
                for (int i = l+1; i < r; i++) {
                    dp[l][r] = Math.max(dp[l][r], balloons[l]*balloons[i]*balloons[r]+dp[l][i]+dp[i][r]);
                }
            }
        }
        return dp[0][balloons.length-1];
    }

}
