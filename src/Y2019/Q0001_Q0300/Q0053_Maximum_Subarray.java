package Y2019.Q0001_Q0300;

public class Q0053_Maximum_Subarray {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int maxSubArray_solution1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            result = Math.max(result, sum);
            if (sum < 0) sum = 0;
        }
        return result;
    }


    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int m = l + (r - l) / 2;
        int lsum = maxSubArray(nums, l, m);
        int rsum = maxSubArray(nums, m + 1, r);
        int csum = maxCrossSum(nums, l, r);
        return Math.max(Math.max(lsum, rsum), csum);
    }

    private int maxCrossSum(int[] nums, int l, int r) {
        int ll = Integer.MIN_VALUE;
        int rr = Integer.MIN_VALUE;
        int m = l + (r - l) / 2;
        int sum = 0;
        for (int i = m; i >= l; i--) {
            sum += nums[i];
            ll = Math.max(ll, sum);
        }
        sum = 0;
        for (int i = m + 1; i <= r; i++) {
            sum += nums[i];
            rr = Math.max(rr, sum);
        }
        return ll + rr;
    }

}
