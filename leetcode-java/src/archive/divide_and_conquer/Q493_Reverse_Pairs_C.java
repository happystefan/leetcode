package archive.divide_and_conquer;

import java.util.*;

public class Q493_Reverse_Pairs_C {

    // BinarySearch : Time Limit Exceeded
    public int reversePairs(int[] nums) {
        ArrayList<Long> list = new ArrayList(nums.length);
        int result = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            int idx = bsearch(list, (long)nums[i]);
            result += idx;
            int insert_idx = bsearch(list, 2l*nums[i]);
            list.add(insert_idx, 2l*nums[i]);
        }
        return result;
    }

    private int bsearch(ArrayList<Long> list, long target) {
        int l = 0, r = list.size()-1;
        while (l <= r) {
            int m = l+(r-l)/2;
            if (list.get(m) < target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l;
    }

}
