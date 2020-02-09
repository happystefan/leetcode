package Y2019.facebook;

import java.util.Arrays;

public class Q0238_Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int product = 1;
        for (int i = 1; i < nums.length; i++) {
            product *= nums[i - 1];
            result[i] *= product;
        }
        product = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            product *= nums[i + 1];
            result[i] *= product;
        }
        return result;
    }

}
