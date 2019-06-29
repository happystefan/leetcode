package Y2018.dp;

public class Q410_Split_Array_Largest_Sum {
    // dfs with memory
    public int splitArray(int[] nums, int m) {
        int[] pre_sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre_sum[i + 1] = pre_sum[i] + nums[i];
        }
        int[][] memo = new int[nums.length][m + 1];
        return dfs(0, nums, m, pre_sum, memo);
    }

    private int dfs(int pos, int[] nums, int m, int[] pre_sum, int[][] memo) {
        if (m == 1) {
            return pre_sum[nums.length] - pre_sum[pos];
        }
        if (memo[pos][m] != 0) {
            return memo[pos][m];
        }
        int max_sum = Integer.MAX_VALUE;
        for (int i = pos + 1; i < nums.length; i++) {
            int l = pre_sum[i] - pre_sum[pos];
            int r = dfs(i, nums, m - 1, pre_sum, memo);
            max_sum = Math.min(max_sum, Math.max(l, r));
        }
        memo[pos][m] = max_sum;
        return max_sum;
    }

}
