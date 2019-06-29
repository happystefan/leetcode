package Y2018.google;

import java.util.*;

public class Q368_Largest_Divisible_Subset {

    Map<Integer, List<Integer>> cache = new HashMap<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return dfs(nums, 0);
    }

    private List<Integer> dfs(int[] nums, int i) {
        if (cache.containsKey(i)) return cache.get(i);
        int d = i == 0 ? 1 : nums[i - 1];
        List<Integer> maxList = new LinkedList<>();
        for (int k = i; k < nums.length; k++) {
            if (nums[k] % d == 0) {
                List<Integer> list = new LinkedList<>(dfs(nums, k + 1));
                list.add(0, nums[i]);
                if (list.size() > maxList.size()) {
                    maxList = list;
                }
            }
        }
        cache.put(i, maxList);
        return maxList;
    }

}
