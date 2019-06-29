package Y2018.facebook;

import java.util.Arrays;

public class Q611_Valid_Triangle_Number {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    result += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }

}
