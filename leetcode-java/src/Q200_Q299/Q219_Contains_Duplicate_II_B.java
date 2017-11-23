package Q200_Q299;

import java.util.HashSet;
import java.util.Set;

public class Q219_Contains_Duplicate_II_B {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i-k-1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }

}
