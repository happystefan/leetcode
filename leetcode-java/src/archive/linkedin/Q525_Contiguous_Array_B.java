package archive.linkedin;

import java.util.HashMap;
import java.util.Map;

public class Q525_Contiguous_Array_B {

    public int findMaxLength(int[] nums) {
        int[] sums = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i-1] + (nums[i-1] == 0 ? -1 : 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < sums.length; i++) {
            if (map.containsKey(sums[i])) {
                result = Math.max(result, i-map.get(sums[i]));
            }
            if (!map.containsKey(sums[i])) {
                map.put(sums[i], i);
            }
        }
        return result;
    }

}
