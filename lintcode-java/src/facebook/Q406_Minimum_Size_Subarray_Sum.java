package facebook;

public class Q406_Minimum_Size_Subarray_Sum {

    public int minimumSize(int[] nums, int s) {
        int l = 0, r = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= s) {
                result = Math.min(result, r-l+1);
                sum -= nums[l++];
            }
            r++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
