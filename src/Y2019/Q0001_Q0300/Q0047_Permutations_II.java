package Y2019.Q0001_Q0300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0047_Permutations_II {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] seen) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (seen[i]) continue;
            seen[i] = true;
            list.add(nums[i]);
            dfs(result, list, nums, seen);
            seen[i] = false;
            list.remove(list.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }

}
