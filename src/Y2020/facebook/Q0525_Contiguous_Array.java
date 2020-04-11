package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0525_Contiguous_Array {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, rslt = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? 1 : -1;
            if (map.containsKey(sum)) rslt = Math.max(rslt, i - map.get(sum));
            map.putIfAbsent(sum, i);
        }
        return rslt;
    }

}
