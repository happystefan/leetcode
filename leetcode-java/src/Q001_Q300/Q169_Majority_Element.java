package Q001_Q300;

import java.util.Arrays;

public class Q169_Majority_Element {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
