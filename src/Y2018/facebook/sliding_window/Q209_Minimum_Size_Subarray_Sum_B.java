package Y2018.facebook.sliding_window;

public class Q209_Minimum_Size_Subarray_Sum_B {

    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] += sums[i] + nums[i];
        }
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (maxSum(sums, m) < s) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return maxSum(sums, l) >= s ? l : 0;
    }

    private int maxSum(int[] sums, int len) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i + len < sums.length; i++) {
            result = Math.max(result, sums[i + len] - sums[i]);
        }
        return result;
    }

}
