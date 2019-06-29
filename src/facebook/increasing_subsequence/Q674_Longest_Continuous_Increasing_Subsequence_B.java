package facebook.increasing_subsequence;

import java.util.Arrays;

public class Q674_Longest_Continuous_Increasing_Subsequence_B {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
