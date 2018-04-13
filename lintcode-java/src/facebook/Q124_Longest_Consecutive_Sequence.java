package facebook;

import java.util.HashSet;
import java.util.Set;

public class Q124_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                continue;
            }
            int cnt = 1;
            int large = num+1;
            int small = num-1;
            while (set.contains(large)) {
                cnt++;
                set.remove(large);
                large++;
            }
            while (set.contains(small)) {
                cnt++;
                set.remove(small);
                small--;
            }
            result = Math.max(result, cnt);
        }
        return result;
    }

}
