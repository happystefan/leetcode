package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0325_Maximum_Size_Subarray_Sum_Equals_k {

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int rslt = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) rslt = Math.max(rslt, i - map.get(sum - k));
            map.putIfAbsent(sum, i);
        }
        return rslt;
    }

}
