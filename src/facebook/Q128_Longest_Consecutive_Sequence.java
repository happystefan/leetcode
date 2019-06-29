package facebook;

import java.util.HashSet;
import java.util.Set;

public class Q128_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num)) {
                continue;
            }
            int cnt = 1;
            set.remove(num);
            while (set.contains(--num)) cnt++;
            num = nums[i];
            while (set.contains(++num)) cnt++;
            result = Math.max(result, cnt);
        }
        return result;
    }

}
