package Y2018.facebook.increasing_subsequence;

public class Q674_Longest_Continuous_Increasing_Subsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = 1;
        int result = 1;
        while (r < nums.length) {
            while (r < nums.length && nums[r] > nums[r - 1]) r++;
            result = Math.max(result, r - l);
            l = r;
            r = l + 1;
        }
        return result;
    }

}
