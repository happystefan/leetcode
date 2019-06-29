package Y2018.facebook.backtracking;

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

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int start, int target) {
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] < 0) break;
            list.add(nums[i]);
            dfs(result, list, nums, i + 1, target - nums[i]);
            list.remove(list.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }

}
