package archive.facebook;

import java.util.*;

public class Q090_Subsets_II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        dfs(result, list, nums, 0);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        if (pos == nums.length) {
            result.add(list);
            return;
        }
        int i = pos;
        int j = pos;
        while (j+1 < nums.length && nums[j+1] == nums[j]) {
            j++;
        }
        for (int k = 0; k <= j-i+1; k++) {
            List<Integer> nlist = new LinkedList<>(list);
            for (int kk = 0; kk < k; kk++) {
                nlist.add(nums[pos]);
            }
            dfs(result, nlist, nums, j+1);
        }
    }

}
