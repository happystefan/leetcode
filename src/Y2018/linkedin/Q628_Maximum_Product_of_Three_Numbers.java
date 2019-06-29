package Y2018.linkedin;

import java.util.Arrays;

public class Q628_Maximum_Product_of_Three_Numbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
    }

}
