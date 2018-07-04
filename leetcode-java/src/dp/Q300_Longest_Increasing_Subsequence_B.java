package dp;

import java.util.*;

public class Q300_Longest_Increasing_Subsequence_B {
    // BinarySearch
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size()-1)) {
                list.add(num);
            } else {
                int pos = bsearch(list, num);
                list.set(pos, num);
            }
        }
        return list.size();
    }

    private int bsearch(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size()-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (list.get(m) < target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l;
    }

}
