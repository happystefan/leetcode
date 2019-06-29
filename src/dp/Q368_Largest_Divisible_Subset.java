package dp;

import java.util.*;

public class Q368_Largest_Divisible_Subset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new LinkedHashMap<>();
        for (int num : nums) {
            dp.put(num, 1);
        }

        int max_len = 1;
        int max_val = nums[0];
        for (int num : nums) {
            for (int i : dp.keySet()) {
                if (i >= num) {
                    break;
                }
                if (num % i == 0) {
                    dp.put(num, Math.max(dp.get(num), dp.get(i) + 1));
                    if (dp.get(num) > max_len) {
                        max_len = dp.get(num);
                        max_val = num;
                    }
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (max_val % num == 0 && dp.get(num) == max_len) {
                result.add(0, num);
                max_len--;
            }
        }
        return result;
    }

}
