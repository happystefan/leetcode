package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0532_K_diff_Pairs_in_an_Array {

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int rslt = 0;
        for (int num : map.keySet()) {
            if (k == 0) {
                if (map.get(num) > 1) rslt++;
            } else {
                if ((map.containsKey(num + k))) rslt++;
            }
        }
        return rslt;
    }

}
