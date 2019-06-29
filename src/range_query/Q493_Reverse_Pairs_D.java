package range_query;

import java.util.Arrays;

public class Q493_Reverse_Pairs_D {

    // Binary Index Tree
    public int reversePairs(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        BIT bit = new BIT(nums);
        int result = 0;
        for (int num : nums) {
            result += bit.query(lower_bound(sorted, num * 2l + 1));
            bit.update(lower_bound(sorted, num * 1l));
        }
        return result;
    }

    private int lower_bound(int[] nums, long target) {
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

    class BIT {
        int[] cnts;

        public BIT(int[] nums) {
            cnts = new int[nums.length + 1];
        }

        public void update(int i) {
            i += 1;
            while (i != 0) {
                cnts[i] += 1;
                i -= i & (-i);
            }
        }

        private int query(int i) {
            i += 1;
            int result = 0;
            while (i < cnts.length) {
                result += cnts[i];
                i += i & (-i);
            }
            return result;
        }
    }
}
