public class Q152_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
       if (nums == null || nums.length == 0) return 0;

       int max = nums[0], min = nums[0], ans = nums[0];
       for (int i = 1; i < nums.length; i++) {
           int nmax = max*nums[i], nmin = min*nums[i];
           max = Math.max(nums[i], nums[i] > 0 ? nmax : nmin);
           min = Math.min(nums[i], nums[i] > 0 ? nmin : nmax);
           ans = Math.max(ans, max);
       }
       return ans;
    }

}
