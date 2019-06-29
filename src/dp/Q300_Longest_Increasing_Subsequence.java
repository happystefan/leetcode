package dp;

import java.util.Arrays;

public class Q300_Longest_Increasing_Subsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    result = Math.max(result, dp[j]);
                }
            }
        }
        return result;
    }

}
