package Y2019.Q0001_Q0300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0090_Subsets_II {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public List<List<Integer>> subsetsWithDup_dfs(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), 0, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int pos, int[] nums) {
        result.add(new LinkedList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, list, i + 1, nums);
            list.remove(list.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: iterative
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new LinkedList<>());
        int start = 0, size = 0;
        for (int i = 0; i < nums.length; i++) {
            start = i > 0 && nums[i] == nums[i - 1] ? size : 0;
            size = result.size();
            for (int j = start; j < size; j++) {
                List<Integer> list = new LinkedList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
        }
        return result;
    }

}
