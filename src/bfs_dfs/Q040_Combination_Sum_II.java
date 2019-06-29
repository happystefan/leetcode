package bfs_dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q040_Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), candidates, 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos, int target) {
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(result, list, nums, i + 1, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }

}
