package facebook;

import java.util.*;

public class Q015_3Sum {

    //  Time Limit Exceeded
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Set<int[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.computeIfAbsent(nums[i] + nums[j], k -> new HashSet<>());
                map.get(nums[i] + nums[j]).add(new int[]{i, j});
            }
        }
        Set<List<Integer>> result = new HashSet<>();
        for (int k = 0; k < nums.length; k++) {
            if (!map.containsKey(-nums[k])) continue;
            for (int[] pair : map.get(-nums[k])) {
                int i = pair[0], j = pair[1];
                if (k <= i || k <= j) continue;
                int[] triple = new int[]{nums[i], nums[j], nums[k]};
                result.add(Arrays.asList(triple[0], triple[1], triple[2]));
            }
        }
        return new LinkedList<>(result);
    }

}
