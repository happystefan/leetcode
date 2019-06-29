package Q001_Q300;

public class Q209_Minimum_Size_Subarray_Sum_C {

    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) sums[i] = nums[i] + (i == 0 ? 0 : sums[i - 1]);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = findWinEnd(i, s, sums);
            if (j == nums.length) break;
            ans = Math.min(ans, j - i + 1);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int findWinEnd(int start, int s, int[] sums) {
        int i = start, j = sums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            int sum = sums[m] - (start == 0 ? 0 : sums[start - 1]);
            if (sum >= s) j = m - 1;
            else i = m + 1;
        }
        return i;
    }

}
