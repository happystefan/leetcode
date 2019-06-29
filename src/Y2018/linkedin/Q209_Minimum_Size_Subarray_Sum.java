package Y2018.linkedin;

public class Q209_Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0, result = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r++];
            while (sum >= s) {
                result = Math.min(result, r - l);
                sum -= nums[l++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
