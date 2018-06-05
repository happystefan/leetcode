package linkedin;

public class Q581_Shortest_Unsorted_Continuous_Subarray_B {

    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int r = -2;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                r = i;
            }
        }
        int l = -1;
        for (int i = nums.length-1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                l = i;
            }
        }
        return r-l+1;
    }

}
