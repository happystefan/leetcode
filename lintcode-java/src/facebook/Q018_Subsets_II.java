package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q018_Subsets_II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, list, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        result.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(result, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }

}
