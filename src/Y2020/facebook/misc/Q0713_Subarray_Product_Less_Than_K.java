package Y2020.facebook.misc;

public class Q0713_Subarray_Product_Less_Than_K {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1, rslt = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            product *= nums[r++];
            while (l < r && product >= k) {
                product /= nums[l++];
            }
            rslt += r - l;
        }
        return rslt;
    }

}
