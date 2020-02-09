package Y2019.Q0001_Q0300;

import java.util.HashSet;
import java.util.Set;

public class Q0128_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int result = 1;
        for (int num : nums) {
            if (!set.contains(num)) continue;
            int cnt = 1, i = num - 1, j = num + 1;
            while (set.contains(i)) {
                set.remove(i--);
                cnt++;
            }
            while (set.contains(j)) {
                set.remove(j++);
                cnt++;
            }
            result = Math.max(result, cnt);
        }
        return result;
    }

}
