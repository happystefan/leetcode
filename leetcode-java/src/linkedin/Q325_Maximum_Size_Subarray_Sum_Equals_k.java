package linkedin;

import java.util.HashMap;
import java.util.Map;

public class Q325_Maximum_Size_Subarray_Sum_Equals_k {

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]-k)) {
                result = Math.max(result, i-map.get(nums[i]-k));
            }
            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        return result;
    }

}
