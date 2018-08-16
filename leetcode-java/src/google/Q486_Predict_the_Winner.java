package google;

import java.util.*;

public class Q486_Predict_the_Winner {

    Integer[][] memo;
    public boolean PredictTheWinner(int[] nums) {
        memo = new Integer[nums.length][nums.length];
        int sum = Arrays.stream(nums).sum();
        return dfs(nums, sum, 0, nums.length-1)*2 >= sum;
    }

    private int dfs(int[] nums, int sum, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        memo[l][r] = Math.max(nums[l]+sum-dfs(nums, sum-nums[l], l+1, r), nums[r]+sum-dfs(nums, sum-nums[r], l, r-1));
        return memo[l][r];
    }

}
