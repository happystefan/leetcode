package Q001_Q300;

import java.util.Arrays;

/**
 * Created by mingqiangliang on 12/18/17.
 */
public class Q259_3Sum_Smaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                if (nums[i] + nums[lo] + nums[hi] < target) {
                    ans += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return ans;
    }

}
