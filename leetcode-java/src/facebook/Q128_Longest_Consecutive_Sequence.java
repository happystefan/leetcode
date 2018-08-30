package facebook;

import java.util.*;

public class Q128_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (!set.contains(num)) continue;
            int cnt = 1;
            int tmp = num+1;
            while (set.contains(tmp)) {
                cnt++;
                set.remove(tmp++);
            }
            tmp = num-1;
            while (set.contains(tmp)) {
                cnt++;
                set.remove(tmp--);
            }
            result = Math.max(result, cnt);
        }
        return result;
    }

}
