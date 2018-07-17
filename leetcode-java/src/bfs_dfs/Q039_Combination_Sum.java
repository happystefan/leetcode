package bfs_dfs;

import java.util.*;

public class Q039_Combination_Sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(result, new LinkedList<>(), candidates, 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos, int target) {
        if (target == 0) {
            result.add(new LinkedList<>(list));
        }
        if (target < 0) {
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, list, nums, i, target-nums[i]);
            list.remove(list.size()-1);
            while (i+1 < nums.length && nums[i+1] == nums[i]) i++;
        }
    }

}
