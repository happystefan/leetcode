package archive.Q001_Q300;

import java.util.HashSet;
import java.util.Set;

public class Q128_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int ans = 1;
        for (int n : nums) {
            if (set.remove(n)) {
                int num = 1;
                int val = n;
                while (set.remove(val - 1)) {
                    val--;
                    num++;
                }
                val = n;
                while (set.remove(val + 1)) {
                    val++;
                    num++;
                }
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }

}
