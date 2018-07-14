package range_query;

import java.util.*;

public class Q327_Count_of_Range_Sum_D {

    // Binary Index Tree
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i]+nums[i];
        }
        long[] sorted = Arrays.copyOf(sums, sums.length);
        int[] cnts = new int[sums.length+1];
        int result = 0;
        for (long sum : sums) {
            result += query(cnts, upper_bound(sorted, sum-lower))-query(cnts, lower_bound(sorted, sum-upper));
            update(cnts, lower_bound(sorted, sum));
        }
        return result;
    }

    private int query(int[] cnts, int i) {
        i += 1;
        int result = 0;
        while (i > 0) {
            result += cnts[i];
            i -= i&-i;
        }
        return result;
    }

    private void update(int[] cnts, int i) {
        i += 1;
        while (i < cnts.length) {
            cnts[i]++;
            i += i&-i;
        }
    }

    private int lower_bound(long[] nums, long target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] < target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l;
    }

    private int upper_bound(long[] nums, long target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] <= target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l;
    }

}
