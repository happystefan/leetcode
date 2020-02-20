package Y2019.Q0301_Q0600;

import java.util.*;

public class Q0368_Largest_Divisible_Subset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = dfs(nums, i, cache);
            if (list.size() > result.size()) result = list;
        }
        return result;
    }

    private List<Integer> dfs(int[] nums, int pos, Map<Integer, List<Integer>> cache) {
        if (cache.containsKey(pos)) return cache.get(pos);
        List<Integer> result = new LinkedList<>();
        for (int i = pos + 1; i < nums.length; i++) {
            List<Integer> list = new LinkedList<>();
            if (nums[i] % nums[pos] == 0) {
                list.addAll(dfs(nums, i, cache));
                if (list.size() > result.size()) result = list;
            }
        }
        result.add(0, nums[pos]);
        cache.put(pos, result);
        return result;
    }

}
