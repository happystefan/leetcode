package linkedin;

import java.math.BigInteger;

public class Q713_Subarray_Product_Less_Than_K {
    //  Time Limit Exceeded
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        BigInteger[] products = new BigInteger[nums.length+1];
        products[0] = BigInteger.valueOf(1);
        for (int i = 1; i < products.length; i++) {
            products[i] = products[i - 1].multiply(BigInteger.valueOf(nums[i - 1]));
        }

        int result = 0;
        for (int l = 1; l < products.length; l++) {
            for (int i = 0; i+l < products.length; i++) {
                if (products[i+l].divide(products[i]).compareTo(BigInteger.valueOf(k)) < 0)  {
                    result++;
                }
            }
        }
        return result;
    }

}
