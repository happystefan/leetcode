package facebook.sliding_window;

import java.util.*;

public class Q560_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return result;
    }

}
