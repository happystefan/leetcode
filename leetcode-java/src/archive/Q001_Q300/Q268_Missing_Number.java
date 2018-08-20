package archive.Q001_Q300;

import java.util.Arrays;

/**
 * Created by mingqiangliang on 12/19/17.
 */
public class Q268_Missing_Number {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

}
