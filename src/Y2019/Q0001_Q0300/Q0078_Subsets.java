package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;

public class Q0078_Subsets {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: iterative
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public List<List<Integer>> subsets_iterative(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new LinkedList<>(result.get(i));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public List<List<Integer>> subsets(int[] nums) {
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
        }
    }

}
