package archive.range_query;

import java.util.*;

public class Q493_Reverse_Pairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = l + (r-l)/2;
        int result = mergeSort(nums, l, m) + mergeSort(nums, m+1, r);
        for (int i = l, j = m+1; i <= m; i++) {
            while (j <= r && (long)nums[i] > 2l*nums[j]) j++;
            result += j-(m+1);
        }

        int[] left = Arrays.copyOfRange(nums, l, m+1);
        int[] right= Arrays.copyOfRange(nums, m+1, r+1);
        for (int k = l, i = 0, j = 0; k <= r; k++) {
            if (j >= right.length) {
                nums[k] = left[i++];
            } else if (i >= left.length) {
                nums[k] = right[j++];
            } else if (left[i] <= right[j]) {
                nums[k] = left[i++];
            } else {
                nums[k] = right[j++];
            }
        }
        return result;
    }

}
