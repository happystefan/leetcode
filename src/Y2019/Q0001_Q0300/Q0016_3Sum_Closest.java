package Y2019.Q0001_Q0300;

import java.util.Arrays;

public class Q0016_3Sum_Closest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;
                if (sum < target) l++;
                else r--;
            }
        }
        return result;
    }

}
