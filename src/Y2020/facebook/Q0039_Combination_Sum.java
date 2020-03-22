package Y2020.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0039_Combination_Sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rslt = new LinkedList<>();
        dfs(rslt, new LinkedList<>(), candidates, 0, target);
        return rslt;
    }

    private void dfs(List<List<Integer>> rslt, List<Integer> list, int[] nums, int pos, int target) {
        if (target == 0) {
            rslt.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (target < nums[i]) continue;
            list.add(nums[i]);
            dfs(rslt, list, nums, i, target - nums[i]);
            list.remove(list.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }

}
