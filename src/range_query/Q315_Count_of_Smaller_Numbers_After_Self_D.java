package range_query;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q315_Count_of_Smaller_Numbers_After_Self_D {

    // BinaryIndexTree
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int[] cnts = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(0, query(cnts, lower_bound(sorted, nums[i])));
            update(cnts, lower_bound(sorted, nums[i] + 1));
        }
        return result;
    }

    private void update(int[] cnts, int i) {
        i += 1;
        while (i < cnts.length) {
            cnts[i]++;
            i += i & -i;
        }
    }

    private int query(int[] cnts, int i) {
        i += 1;
        int result = 0;
        while (i > 0) {
            result += cnts[i];
            i -= i & -i;
        }
        return result;
    }

    private int lower_bound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

}
