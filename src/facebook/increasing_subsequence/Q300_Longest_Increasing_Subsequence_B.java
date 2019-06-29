package facebook.increasing_subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q300_Longest_Increasing_Subsequence_B {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) list.add(num);
            else {
                int idx = Collections.binarySearch(list, num);
                if (idx < 0) idx = -(idx + 1);
                list.set(idx, num);
            }
        }
        return list.size();
    }

}
