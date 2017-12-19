package Q200_Q299;

import java.util.Arrays;

/**
 * Created by mingqiangliang on 12/19/17.
 */
public class Q268_Missing_Number_D {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int m = (lo+hi)/2;
            if (nums[m] > m) hi = m;
            else if (nums[m] < m) lo = m;
            else lo = m+1;
        }
        return lo;
    }

}
