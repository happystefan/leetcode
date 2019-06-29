package facebook;

import java.util.*;

public class Q018_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, Integer> histogram = new HashMap<>();
        for (int num : nums) {
            histogram.put(num, histogram.getOrDefault(num, 0) + 1);
        }
        int n = 0;
        for (int num : histogram.keySet()) {
            for (int i = 0; i < Math.min(histogram.get(num), 4); i++) {
                nums[n++] = num;
            }
        }

        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                map.computeIfAbsent(nums[i] + nums[j], k -> new HashSet<>());
                map.get(nums[i] + nums[j]).add(Arrays.asList(i, j));
            }
        }
        Set<List<Integer>> result = new HashSet<>();
        for (int twoSum : map.keySet()) {
            if (!map.containsKey(target - twoSum)) continue;
            for (List<Integer> ab : map.get(twoSum)) {
                for (List<Integer> cd : map.get(target - twoSum)) {
                    int a = ab.get(0), b = ab.get(1), c = cd.get(0), d = cd.get(1);
                    if (b < c) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                    }
                }
            }
        }
        return new LinkedList<>(result);
    }

}
