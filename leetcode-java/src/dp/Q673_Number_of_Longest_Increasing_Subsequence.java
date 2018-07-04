package dp;

import java.util.*;

public class Q673_Number_of_Longest_Increasing_Subsequence {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] cnt= new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt,1);
        int max_len = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                // dp[j] = Math.max(dp[j], dp[i]+1);
                if (nums[j] > nums[i]) {
                    if (dp[i] >= dp[j]) {
                        dp[j] = dp[i]+1;
                        cnt[j] = cnt[i];
                    } else if (dp[i]+1 == dp[j]){
                        cnt[j] += cnt[i];
                    }
                    max_len = Math.max(max_len, dp[j]);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            if (max_len == dp[i]) {
                result += cnt[i];
            }
        }
        return result;
    }

}
