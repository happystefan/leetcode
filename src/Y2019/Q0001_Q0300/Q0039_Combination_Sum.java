package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;

public class Q0039_Combination_Sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), 0, target, candidates);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int pos, int target, int[] nums) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, list, i, target - nums[i], nums);
            list.remove(list.size() - 1);
        }
    }

}
