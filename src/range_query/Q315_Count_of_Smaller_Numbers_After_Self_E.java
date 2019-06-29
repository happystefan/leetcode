package range_query;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q315_Count_of_Smaller_Numbers_After_Self_E {

    // BinaryIndexTree
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        BIT bit = new BIT(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(0, bit.query(nums[i] - 1));
            bit.update(nums[i]);
        }
        return result;
    }

    class BIT {
        Map<Integer, Integer> map = new HashMap<>();
        int min, max;

        public BIT(int[] nums) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }

        private void update(int val) {
            val = Math.min(val, max);
            int i = val - min + 1;
            while (i <= max - min + 1) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                i += i & -i;
            }
        }

        private int query(int val) {
            val = Math.min(val, max);
            int i = val - min + 1;
            int result = 0;
            while (i > 0) {
                result += map.getOrDefault(i, 0);
                i -= i & -i;
            }
            return result;
        }
    }

}
