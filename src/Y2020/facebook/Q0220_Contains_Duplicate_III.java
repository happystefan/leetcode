package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q0220_Contains_Duplicate_III {

    class solution1_tree {

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                Integer ceil = set.ceiling(nums[i]);
                Integer floor = set.floor(nums[i]);
                if (ceil != null && nums[i] >= ceil - t) return true;
                if (floor != null && nums[i] <= floor + t) return true;
                set.add(nums[i]);
                if (set.size() > k) set.remove(nums[i - k]);
            }
            return false;
        }

    }

    class solution2_bucket_sort {

        private long hashFun(int num, int w) {
            return ((long) num - Integer.MIN_VALUE) / (Math.abs((long) w) + 1);
        }

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            Map<Long, Long> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                long key = hashFun(num, t);
                if (map.containsKey(key) && t >= 0) return true;
                if (map.containsKey(key - 1) && num - map.get(key - 1) <= t) return true;
                if (map.containsKey(key + 1) && map.get(key + 1) - num <= t) return true;
                map.put(key, (long) num);
                if (i >= k) map.remove(hashFun(nums[i - k], t));
            }
            return false;
        }

    }

}
