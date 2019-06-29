package range_query;

import java.util.ArrayList;
import java.util.List;

public class Q315_Count_of_Smaller_Numbers_After_Self {
    // BinarySearch: Time complexity is O(N^2*log(N)) because of list insertion
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = nums.length; i >= 0; i--) {
            int idx = bsearch(list, nums[i]);
            result.add(0, idx);
            list.add(idx, nums[i]);
        }
        return result;
    }

    private int bsearch(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m) < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

}
