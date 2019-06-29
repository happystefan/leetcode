package google;

import java.util.HashSet;
import java.util.Set;

public class Q128_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int ans = 0;
        for (int num : nums) {
            int sum = 1;
            int val = num;
            while (set.contains(val - 1)) {
                set.remove(val);
                sum++;
                val--;
            }
            val = num;
            while (set.contains(val + 1)) {
                set.remove(val);
                sum++;
                val++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
