package google;

import java.util.Map;
import java.util.TreeMap;

public class Q327_Count_of_Range_Sum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        TreeMap<Long, Long> map = new TreeMap<>();
        map.put(0l, 1l);
        long sum = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Map<Long, Long> sub = map.subMap(sum-upper, true, sum-lower, true);
            for (long value : sub.values()) {
                cnt += value;
            }
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            } else {
                map.put(sum, 1l);
            }
        }
        return (int)cnt;
    }

}
