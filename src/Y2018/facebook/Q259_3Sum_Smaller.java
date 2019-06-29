package Y2018.facebook;

import java.util.Arrays;

public class Q259_3Sum_Smaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i + 2 < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < target) {
                    result += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

}
