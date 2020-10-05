package Y2020.linkedin.algo_part1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q001_Array_Equal_Partition {

    class solution_dfs {

        public boolean isDivisible(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0) return false;
            int sum = IntStream.of(nums).sum();
            if (sum % k != 0) return false;

            { // optimization:
                Arrays.sort(nums);
                if (nums[nums.length - 1] > sum / k) return false;
            }

            return dfs(nums, new int[k], 0, sum / k);
        }

        private boolean dfs(int[] nums, int[] sums, int pos, int target) {
            if (pos == nums.length) return true;
            for (int i = 0; i < sums.length; i++) {
                if (sums[i] + nums[pos] > target) continue;
                sums[i] += nums[pos];
                if (dfs(nums, sums, pos + 1, target)) return true;
                sums[i] -= nums[pos];
                if (sums[i] == 0) break;
            }
            return false;
        }

    }
    /*
    Time Complexity: O(k^{N-k} k!), where NN is the length of nums,
    and k is as given. As we skip additional zeroes in groups,
    naively we will make O(k!) calls to search, then an additional
    O(k^{N-k}) calls after every element of groups is nonzero.
    */

}
