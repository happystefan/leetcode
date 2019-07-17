package Y2019.Q0001_Q0300;

public class Q0055_Jump_Game {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: dp
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public boolean canJump_dp(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int l = i, r = Math.min(i + nums[i], n - 1);
            for (int j = l; j <= r; j++) dp[j] |= dp[i];
        }
        return dp[n - 1];
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int i = 0;
        for (int r = 0; i < n && i <= r; i++) {
            r = Math.max(r, i + nums[i]);
        }
        return i == n;
    }

}
