package archive.facebook;

import java.util.*;

public class Q078_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        dfs(result, list, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int i) {
        if (i == nums.length) {
            result.add(list);
            return;
        }
        // dfs(result, list, nums, i+1);
        // list.add(nums[i]);
        // dfs(result, list, nums, i+1);
        // list.remove(list.size()-1);

        List<Integer> nlist = new LinkedList<>(list);
        dfs(result, nlist, nums, i+1);
        nlist = new LinkedList<>(list);
        nlist.add(nums[i]);
        dfs(result, nlist, nums, i+1);
    }

}
