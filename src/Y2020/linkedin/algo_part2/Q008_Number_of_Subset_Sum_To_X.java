package Y2020.linkedin.algo_part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q008_Number_of_Subset_Sum_To_X {

    // TC: 2^N -- number of subset
    class solution_recursive {

        public int numSubsets(int[] nums, int target) {
            return numSubsets(nums, 0, target);
        }

        private int numSubsets(int[] nums, int pos, int target) {
            if (pos == nums.length) return 0;
            return (nums[pos] == target ? 1 : 0)
                    + numSubsets(nums, pos + 1, target)
                    + numSubsets(nums, pos, target - nums[pos]);
        }
    }

    class solution_dfs {

        public int numSubsets(int[] nums, int target) {
            List<List<Integer>> rslt = new LinkedList<>();
            dfs(rslt, new ArrayList<>(), 0, nums, target);
            return rslt.size();
        }

        private void dfs(List<List<Integer>> rslt, List<Integer> list,
                         int pos, int[] nums, int target) {
            if (target == 0) {
                rslt.add(new ArrayList<>(list));
            }
            for (int i = pos; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(rslt, list, i + 1, nums, target - nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }

}
