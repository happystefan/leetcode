package Y2019.facebook;

public class Q0152_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newMax = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            int newMin = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            max = newMax;
            min = newMin;
            result = Math.max(result, max);
        }
        return result;
    }

}
