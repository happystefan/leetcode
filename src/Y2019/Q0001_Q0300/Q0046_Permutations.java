package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;

public class Q0046_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            dfs(result, list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

}
