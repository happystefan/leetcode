package facebook;

import java.util.*;

public class Q525_Contiguous_Array {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? 1 : -1;
            result = Math.max(result, i-map.getOrDefault(sum, i));
            map.putIfAbsent(sum, i);
        }
        return result;
    }

}
