package range_query;

import java.util.*;

public class Q325_Maximum_Size_Subarray_Sum_Equals_k {

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, i-map.getOrDefault(sum-k, i));
            map.putIfAbsent(sum, i);
        }
        return result;
    }

}
