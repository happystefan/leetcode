package Y2020.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0047_Permutations_II {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rslt = new LinkedList<>();
        dfs(rslt, new LinkedList<>(), nums, new boolean[nums.length]);
        return rslt;
    }

    private void dfs(List<List<Integer>> rslt, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            rslt.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            dfs(rslt, list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }

}
