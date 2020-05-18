package Y2020.facebook.misc;

import java.util.Arrays;

public class Q0581_Shortest_Unsorted_Continuous_Subarray {

    class solution_sort {

        public int findUnsortedSubarray(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] sorted = nums.clone();
            Arrays.sort(sorted);
            int l = nums.length - 1, r = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == sorted[i]) continue;
                l = Math.min(l, i);
                r = Math.max(r, i);
            }
            return r > l ? r - l + 1 : 0;
        }

    }

    class solution_2 {

        public int findUnsortedSubarray(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int l = 0, r = 0;
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
                if (nums[i] < max) r = i;
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                min = Math.min(min, nums[i]);
                if (nums[i] > min) l = i;
            }
            return l == 0 && r == 0 ? 0 : r - l + 1;
        }

    }

}
