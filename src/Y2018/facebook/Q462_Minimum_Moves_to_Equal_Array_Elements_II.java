package Y2018.facebook;

import java.util.Arrays;

public class Q462_Minimum_Moves_to_Equal_Array_Elements_II {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            result += nums[j] - nums[i];
            i++;
            j--;
        }
        return result;
    }

}
