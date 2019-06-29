package Y2018.dp;

import java.util.Arrays;

public class Q334_Increasing_Triplet_Subsequence {

    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    if (dp[j] == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
