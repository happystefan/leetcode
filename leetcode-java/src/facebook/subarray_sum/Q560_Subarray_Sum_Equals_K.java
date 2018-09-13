package facebook.subarray_sum;

import java.util.*;

public class Q560_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0, sum = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            result += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return result;
    }

}
