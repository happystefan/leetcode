package facebook;

import java.util.*;

public class Q078_Subsets_B {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        result.add(new LinkedList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }


}
