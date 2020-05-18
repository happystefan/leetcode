package Y2020.facebook.misc;

import java.util.Arrays;

public class Q0259_3Sum_Smaller {

    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;
        Arrays.sort(nums);
        int rslt = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    rslt += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return rslt;
    }

}
