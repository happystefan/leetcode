package Y2018.dp;

public class Q486_Predict_the_Winner {

    Integer[][] memo;

    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        memo = new Integer[nums.length][nums.length];
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int l = 0, r = nums.length - 1;
        return dfs(nums, l, r, sum) * 2 >= sum;
    }

    private int dfs(int[] nums, int l, int r, int sum) {
        if (l == r) {
            return nums[l];
        }
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        memo[l][r] = Math.max(nums[l] + sum - dfs(nums, l + 1, r, sum - nums[l]), nums[r] + sum - dfs(nums, l, r - 1, sum - nums[r]));
        return memo[l][r];
    }

}

