package facebook.dp;

public class Q213_House_Robber_II {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob(nums, 0, n-1), rob(nums, 1, n));
    }

    private int rob(int[] nums, int l, int h) {
        int[] dp = new int[h+1];
        dp[l] = 0;
        dp[l+1] = nums[l];
        for (int i = l+1; i < h; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
        }
        return dp[h];
    }

}
