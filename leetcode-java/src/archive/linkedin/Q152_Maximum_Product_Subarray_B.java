package archive.linkedin;

public class Q152_Maximum_Product_Subarray_B {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(nums[i], Math.max(nums[i]*max, nums[i]*min));
            min = Math.min(nums[i], Math.min(nums[i]*tmp, nums[i]*min));
            result = Math.max(result, max);
        }
        return result;
    }

}
