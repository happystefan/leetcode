package archive.google;

public class Q494_Target_Sum {

    public int findTargetSumWays(int[] nums, int S) {
        int[] result = new int[1];
        dfs(result, nums, 0, 0, S);
        return result[0];
    }

    private void dfs(int[] result, int[]nums, int pos, int sum, int target) {
        if (pos == nums.length && sum == target) {
            result[0]++;
            return;
        }
        dfs(result, nums, pos+1, sum+nums[pos], target);
        dfs(result, nums, pos+1, sum-nums[pos], target);
    }

}
