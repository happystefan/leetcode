package range_query;

import java.util.*;

public class Q327_Count_of_Range_Sum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n+1];
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i]+nums[i];
        }
        return mergeSort(sums, 0, sums.length-1, lower, upper);
    }

    private int mergeSort(long[] sums, int l, int r, int lower, int upper) {
        if (l >= r) {
            return 0;
        }
        int m = l + (r-l)/2;
        int result = mergeSort(sums, l, m, lower, upper) +
                mergeSort(sums, m+1, r, lower, upper);

        for (int k = l, i = m+1, j = m+1; k <= m; k++) {
            while (i <= r && sums[i] - sums[k] < lower) i++;
            while (j <= r && sums[j] - sums[k] <= upper) j++;
            result += j - i;
        }

        long[] left = Arrays.copyOfRange(sums, l, m+1);
        long[] right= Arrays.copyOfRange(sums, m+1, r+1);
        for (int k = l, i = 0, j = 0; k <= r; k++) {
            if (i >= left.length) {
                sums[k] = right[j++];
            } else if (j >= right.length) {
                sums[k] = left[i++];
            } else if (left[i] <= right[j]) {
                sums[k] = left[i++];
            } else {
                sums[k] = right[j++];
            }
        }
        return result;
    }

}
