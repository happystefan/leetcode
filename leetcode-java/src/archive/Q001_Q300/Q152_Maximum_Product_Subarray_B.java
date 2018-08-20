package archive.Q001_Q300;

public class Q152_Maximum_Product_Subarray_B {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, product = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, product *= nums[i]);
            if (nums[i] == 0) product = 1;
        }
        product = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            max = Math.max(max, product *= nums[i]);
            if (nums[i] == 0) product = 1;
        }
        return max;
    }

}
