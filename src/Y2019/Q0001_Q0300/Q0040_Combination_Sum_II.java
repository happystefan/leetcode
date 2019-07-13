package Y2019.Q0001_Q0300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0040_Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            dfs(result, list, i + 1, target - nums[i], nums);
            list.remove(list.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }

}
