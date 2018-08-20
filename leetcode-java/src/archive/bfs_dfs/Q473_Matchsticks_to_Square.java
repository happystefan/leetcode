package archive.bfs_dfs;

import java.util.*;

public class Q473_Matchsticks_to_Square {

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 4 != 0) {
            return false;
        }
        return dfs(nums, new int[4], 0, sum/4);
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
        }
        return false;
    }

}
