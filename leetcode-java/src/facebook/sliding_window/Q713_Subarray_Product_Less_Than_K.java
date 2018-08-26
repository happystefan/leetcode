package facebook.sliding_window;

public class Q713_Subarray_Product_Less_Than_K {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int result = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            product *= nums[r++];
            while (l < r && product >= k) {
                product /= nums[l++];
            }
            result += r-l;
        }
        return result;
    }

}
