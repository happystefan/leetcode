package archive.Q001_Q300;

import java.util.TreeSet;

public class Q220_Contains_Duplicate_III {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums == null || nums.length == 0 || k <= 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long)nums[i]+(long)t);
            Long ceil = set.ceiling((long)nums[i]-(long)t);
            if (floor != null && floor >= nums[i] || ceil != null && ceil <= nums[i]) return true;
            set.add((long)nums[i]);
            if (i >= k) set.remove((long)nums[i-k]);
        }
        return false;

    }

}
