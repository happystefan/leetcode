package Y2018.divide_and_conquer;

import java.util.Map;
import java.util.TreeMap;

public class Q493_Reverse_Pairs {

    // TreeMap: Time Limit Exceeded
    public int reversePairs(int[] nums) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            Map<Long, Integer> sub = map.headMap((long) nums[i]);
            for (int val : sub.values()) {
                result += val;
            }
            map.put(2l * nums[i], map.getOrDefault(2l * nums[i], 0) + 1);
        }
        return result;
    }

}
