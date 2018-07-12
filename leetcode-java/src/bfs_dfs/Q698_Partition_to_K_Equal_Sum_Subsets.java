package bfs_dfs;

import java.util.*;

public class Q698_Partition_to_K_Equal_Sum_Subsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        return dfs(nums, new int[k], 0, sum/k);
    }

    private boolean dfs(int[] nums, int[] sums, int pos, int target) {
        if (pos == nums.length) {
            return true;
        }
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] + nums[pos] > target) {
                continue;
            }
            sums[i] += nums[pos];
            if (dfs(nums, sums, pos+1, target)) {
                return true;
            }
            sums[i] -= nums[pos];
            if (sums[i] == 0) break;
        }
        return false;
    }

}
