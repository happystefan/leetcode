package facebook.increasing_subsequence;

import java.util.ArrayList;
import java.util.List;

public class Q300_Longest_Increasing_Subsequence_C {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) list.add(num);
            else {
                int idx = bsearch(list, num);
                list.set(idx, num);
            }
        }
        return list.size();
    }

    private int bsearch(List<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums.get(m) < target) l = m + 1;
            else r = m;
        }
        return l;
    }

}
