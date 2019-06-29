package Y2018.facebook.sliding_window;

public class Q209_Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] += sums[i] + nums[i];
        }
        int result = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while (r < sums.length) {
            if (sums[r] - sums[l] < s) r++;
            while (r < sums.length && sums[r] - sums[l] >= s) {
                result = Math.min(result, r - l);
                l++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
