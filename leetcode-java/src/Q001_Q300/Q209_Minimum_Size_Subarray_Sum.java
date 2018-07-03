package Q001_Q300;

public class Q209_Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = 0, sum = 0;
        int ans = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r++];
            while (sum >= s) {
                ans = Math.min(ans, r-l);
                sum -= nums[l++];
            }
        }
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }

}
