package Q001_Q100;

import java.util.Arrays;

/**
 * Created by mqliang on 5/30/17.
 */
public class Q016_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int l = i+1;
            int r = nums.length-1;
            while (l < r) {
                int sum = nums[i]+nums[l]+nums[r];
                if (Math.abs(sum-target) < Math.abs(ans-target)) {
                    ans = sum;
                }
                if (sum == target) {
                    return ans;
                } else if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                }
            }
        }
        return ans;
    }
}
