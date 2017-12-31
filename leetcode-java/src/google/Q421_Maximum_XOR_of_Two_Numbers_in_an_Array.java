package google;

import java.util.HashSet;
import java.util.Set;

public class Q421_Maximum_XOR_of_Two_Numbers_in_an_Array {

    public int findMaximumXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            set.clear();
            mask |= 1 << i;
            for (int num : nums) set.add(num&mask);
            int nxt = ans | (1<<i);
            for (int prefix : set) {
                if (set.contains(nxt^prefix)) {
                    ans = nxt;
                    break;
                }
            }
        }
        return ans;
    }

}
