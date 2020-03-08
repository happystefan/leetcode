package Y2020.facebook;

public class Q0713_Subarray_Product_Less_Than_K_Medium {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1) return 0;
        int l = 0, r = 0, prod = 1, rslt = 0;
        while (r < nums.length) {
            prod *= nums[r];
            while (prod >= k) prod /= nums[l++];
            rslt += r - l + 1;
            r++;
        }
        return rslt;
    }

}
