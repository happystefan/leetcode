package Q001_Q300;

public class Q209_Minimum_Size_Subarray_Sum_B {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length, ans = Integer.MAX_VALUE;
        while (l <= r) {
            int m = (l+r)/2;
            if (winExist(m, s, nums)){
                r = m-1;
                ans = Math.min(ans, m);
            } else l = m+1;
        }
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }

    public boolean winExist(int size, int s, int[]nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size) sum -= nums[i-size];
            sum += nums[i];
            if (sum >= s) return true;
        }
        return false;
    }

}
