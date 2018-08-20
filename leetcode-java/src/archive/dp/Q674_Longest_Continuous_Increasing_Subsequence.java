package archive.dp;

import java.util.*;

public class Q674_Longest_Continuous_Increasing_Subsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1]+1;
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

}
