package dp;

public class Q377_Combination_Sum_IV {

    // DFS: Time Limit Exceeded
    public int combinationSum4(int[] nums, int target) {
        int[] result = new int[1];
        dfs(result, nums, target);
        return result[0];
    }

    private void dfs(int[] result, int[] nums, int target) {
        if (target == 0) {
            result[0] += 1;
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            dfs(result, nums, target-nums[i]);
        }
    }

}
