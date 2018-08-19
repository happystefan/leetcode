package backtracking;

import java.util.*;

public class Q047_Permutations_II {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            dfs(result, list, nums, visited);
            list.remove(list.size()-1);
            visited[i] = false;
            while (i+1 < nums.length && nums[i+1] == nums[i]) i++;
        }
    }

}
