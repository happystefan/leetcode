package Y2018.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q090_Subsets_II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        result.add(new LinkedList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, list, nums, i + 1);
            list.remove(list.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }

}
