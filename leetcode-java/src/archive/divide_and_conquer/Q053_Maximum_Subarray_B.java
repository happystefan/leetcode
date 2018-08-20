package archive.divide_and_conquer;

public class Q053_Maximum_Subarray_B {

    public int maxSubArray(int[] nums) {
        return maxSum(nums, 0, nums.length-1);
    }

    private int maxSum(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int m = l + (r-l)/2;
        int ll = maxSum(nums, l, m);
        int rr = maxSum(nums, m+1, r);
        int mm = cross(nums, l, r);
        return Math.max(mm, Math.max(ll, rr));
    }

    private int cross(int[] nums, int l, int r) {
        int m = l + (r-l)/2;
        int ll = Integer.MIN_VALUE;
        int rr = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = m; i >= l; i--) {
            sum += nums[i];
            if (sum > ll) {
                ll = sum;
            }
        }
        sum = 0;
        for (int i = m+1; i <= r; i++) {
            sum += nums[i];
            if (sum > rr) {
                rr = sum;
            }
        }
        return ll+rr;
    }

}
