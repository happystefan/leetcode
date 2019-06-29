package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q040_Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), candidates, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int target, int pos) {
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                continue;
            }
            list.add(nums[i]);
            dfs(result, list, nums, target - nums[i], i + 1);
            list.remove(list.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }

}
