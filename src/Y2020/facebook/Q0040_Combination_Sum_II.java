package Y2020.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0040_Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rslt = new LinkedList<>();
        dfs(rslt, new LinkedList<>(), candidates, target, 0);
        return rslt;
    }

    private void dfs(List<List<Integer>> rslt, List<Integer> list, int[] nums, int target, int pos) {
        if (target == 0) {
            rslt.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] > target) continue;
            list.add(nums[i]);
            dfs(rslt, list, nums, target - nums[i], i + 1);
            list.remove(list.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }

}
