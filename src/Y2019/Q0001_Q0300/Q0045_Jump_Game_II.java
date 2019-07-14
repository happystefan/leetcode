package Y2019.Q0001_Q0300;

import java.util.Arrays;

public class Q0045_Jump_Game_II {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: dp
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int jump_dp(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= nums[i]; j++) {
                if (i + j >= n) continue;
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[n];
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: bfs
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = 0;
        int result = 0;
        while (r < nums.length - 1) {
            int ll = r, rr = r;
            for (int i = l; i <= r; i++) {
                rr = Math.max(rr, i + nums[i]);
            }
            l = ll;
            r = rr;
            result++;
        }
        return result;
    }

}
