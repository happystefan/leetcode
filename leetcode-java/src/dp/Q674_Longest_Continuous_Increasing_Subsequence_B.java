package dp;

public class Q674_Longest_Continuous_Increasing_Subsequence_B {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        int l = 0, r = 0;
        while (r < nums.length) {
            while (r+1 < nums.length && nums[r+1] > nums[r]) {
                r++;
            }
            result = Math.max(result, r-l+1);
            r++;
            l = r;
        }
        return result;
    }

}
