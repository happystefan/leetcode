package archive.backtracking;

import java.util.*;

public class Q039_Combination_Sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (target-nums[i] < 0) {
                continue;
            }
            list.add(nums[i]);
            dfs(result, list, nums, target-nums[i], i);
            list.remove(list.size()-1);
        }
    }

}
