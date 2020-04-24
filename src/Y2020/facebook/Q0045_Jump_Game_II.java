package Y2020.facebook;

import java.util.Arrays;

public class Q0045_Jump_Game_II {

    class solution_dp {

        public int jump(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] dp = new int[nums.length];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
            return dp[nums.length - 1];
        }

    }

    class solution_greedy {

        public int jump(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int l = 0, r = 0, rslt = 0;
            while (r < nums.length - 1) {
                int ll = r;
                int rr = r;
                for (int i = l; i <= r; i++) rr = Math.max(rr, i + nums[i]);
                l = ll;
                r = rr;
                rslt++;
            }
            return rslt;
        }

    }

}
