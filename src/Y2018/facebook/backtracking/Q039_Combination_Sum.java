package Y2018.facebook.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Q039_Combination_Sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), candidates, 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos, int target) {
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (target - nums[i] < 0) continue;
            list.add(nums[i]);
            dfs(result, list, nums, i, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }

}
