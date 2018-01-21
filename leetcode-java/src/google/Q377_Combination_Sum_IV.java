package google;

import java.util.Arrays;

public class Q377_Combination_Sum_IV {

    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target+1];
        Arrays.fill(cache, -1);
        cache[0] = 1;
        return dfs(nums, target, cache);
    }

    private int dfs(int[] nums, int target, int[] cache) {
        if (cache[target] != -1) return cache[target];
        int ans = 0;
        for (int num : nums) {
            if (target > num) continue;
            ans += dfs(nums, target-num, cache);
        }
        cache[target] = ans;
        return ans;
    }

}
