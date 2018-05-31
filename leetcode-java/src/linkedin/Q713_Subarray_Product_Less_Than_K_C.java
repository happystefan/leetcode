package linkedin;

public class Q713_Subarray_Product_Less_Than_K_C {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0;
        int product = 1;
        int result = 0;
        while (r < nums.length) {
            product *= nums[r];
            while (l <= r && product >= k) {
                product /= nums[l];
                l++;
            }
            result += r-l+1;
            r++;
        }
        return result;
    }

}
