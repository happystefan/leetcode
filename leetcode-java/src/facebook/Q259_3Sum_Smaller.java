package facebook;

import java.util.*;

public class Q259_3Sum_Smaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = i+1, r = nums.length-1;
            while (l < r) {
                int sum = nums[i]+nums[l]+nums[r];
                if (sum >= target) r--;
                else {
                    result += r-l;
                    l++;
                }
            }
        }
        return result;
    }

}
