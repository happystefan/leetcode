package range_query;

import java.util.*;

public class Q239_Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> result = new LinkedList<>();
        for (int i = k; i < nums.length; i++) {
            result.add(map.lastKey());
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            map.put(nums[i-k], map.get(nums[i-k])-1);
            if (map.get(nums[i-k]) == 0) {
                map.remove(nums[i-k]);
            }
        }
        if (!map.isEmpty()) {
            result.add(map.lastKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
