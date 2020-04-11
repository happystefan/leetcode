package Y2020.facebook;

import java.util.TreeMap;

public class Q0209_Minimum_Size_Subarray_Sum {

    class solution_sliding_window {

        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int l = 0, r = 0, sum = 0, rslt = Integer.MAX_VALUE;
            while (r < nums.length) {
                sum += nums[r++];
                while (l < r && sum >= s) {
                    rslt = Math.min(rslt, r - l);
                    sum -= nums[l++];
                }
            }
            return rslt == Integer.MAX_VALUE ? 0 : rslt;
        }

    }

    class solution_tree_map {

        public int minSubArrayLen(int s, int[] nums) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, -1);
            int sum = 0;
            int rslt = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                Integer floor = map.floorKey(sum - s);
                if (floor != null) rslt = Math.min(rslt, i - map.get(floor));
                map.put(sum, i);
            }
            return rslt == Integer.MAX_VALUE ? 0 : rslt;
        }

    }



}
