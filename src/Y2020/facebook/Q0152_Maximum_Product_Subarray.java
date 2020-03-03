package Y2020.facebook;

public class Q0152_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0], max = nums[0], rslt = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = min;
            min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
            max = Math.max(nums[i], Math.max(nums[i] * tmp, nums[i] * max));
            rslt = Math.max(rslt, max);
        }
        return rslt;
    }

}
