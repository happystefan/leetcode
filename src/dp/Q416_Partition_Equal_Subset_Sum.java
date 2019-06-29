package dp;

public class Q416_Partition_Equal_Subset_Sum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = dp.length - 1; i >= 0; i--) {
                if (i - num >= 0) {
                    dp[i] |= dp[i - num];
                }
            }
        }
        return dp[target];
    }

}
