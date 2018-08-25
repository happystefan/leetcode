package facebook;

public class Q152_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
            min = Math.min(nums[i], Math.min(min*nums[i], tmp*nums[i]));
            result = Math.max(result, max);
        }
        return result;
    }

}
