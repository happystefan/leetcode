package Y2020.facebook;

import java.util.*;

public class Q1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> uniq_nums = new LinkedList<>(map.keySet());
        Collections.sort(uniq_nums);
        for (int num : uniq_nums) {
            int cnt = map.get(num);
            if (cnt == 0) continue;
            for (int i = num; i < num + k; i++) {
                if (!map.containsKey(i) || map.get(i) < cnt) return false;
                map.put(i, map.get(i) - cnt);
            }
        }
        return true;
    }

}
