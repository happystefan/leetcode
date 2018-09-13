package facebook.dp;

import java.util.*;

public class Q494_Target_Sum {

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> tmp = new HashMap<>();
            for (int j : map.keySet()) {
                tmp.put(j+num, tmp.getOrDefault(j+num, 0)+map.get(j));
                tmp.put(j-num, tmp.getOrDefault(j-num, 0)+map.get(j));
            }
            map = tmp;
        }
        return map.getOrDefault(S, 0);
    }

}
