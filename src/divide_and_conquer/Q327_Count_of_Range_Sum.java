package divide_and_conquer;

import java.util.Map;
import java.util.TreeMap;

public class Q327_Count_of_Range_Sum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Long> map = new TreeMap();
        map.put(0l, 1l);
        long sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
            Map<Long, Long> sub = map.subMap(sum - upper, true, sum - lower, true);
            for (long cnt : sub.values()) {
                result += cnt;
            }
            map.put(sum, map.getOrDefault(sum, 0l) + 1);
        }
        return result;
    }

}
