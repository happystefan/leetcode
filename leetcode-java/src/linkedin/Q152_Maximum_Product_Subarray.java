package linkedin;

import java.util.Arrays;

public class Q152_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, 1);
        int result = Integer.MIN_VALUE;
        for (int l = 0; l < nums.length; l++) {
            for (int i = 0; i+l < nums.length; i++) {
                dp[i] *= nums[i+l];
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

}
