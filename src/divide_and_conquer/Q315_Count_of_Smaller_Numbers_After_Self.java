package divide_and_conquer;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Q315_Count_of_Smaller_Numbers_After_Self {

    // TreeMap: Time Limit Exceeded
    public List<Integer> countSmaller(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> result = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            Map<Integer, Integer> sub = map.headMap(nums[i]);
            int cnt = 0;
            for (int val : sub.values()) {
                cnt += val;
            }
            result.add(0, cnt);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return result;
    }

}
