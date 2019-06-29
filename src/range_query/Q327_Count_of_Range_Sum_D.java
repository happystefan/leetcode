package range_query;

import java.util.HashMap;
import java.util.Map;

public class Q327_Count_of_Range_Sum_D {

    // Binary Index Tree
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        BIT bit = new BIT(sums);
        int result = 0;
        for (long sum : sums) {
            result += bit.query(sum - lower) - bit.query(sum - upper - 1);
            bit.update(sum);
        }
        return result;
    }

    class BIT {
        Map<Long, Integer> map = new HashMap<>();
        long min, max;

        public BIT(long[] sums) {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            for (long sum : sums) {
                min = Math.min(min, sum);
                max = Math.max(max, sum);
            }
        }

        private int query(long val) {
            val = Math.min(max, val);
            long i = val - min + 1;
            int result = 0;
            while (i > 0) {
                result += map.getOrDefault(i, 0);
                i -= i & -i;
            }
            return result;
        }

        private void update(long val) {
            long i = val - min + 1;
            while (i <= max - min + 1) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                i += i & -i;
            }
        }

    }

}
