package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0560_Subarray_Sum_Equals_K {

    class solution1_pre_sum {

        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0;
            int rslt = 0;
            for (int num : nums) {
                sum += num;
                rslt += map.getOrDefault(sum - k, 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return rslt;
        }

    }

}
