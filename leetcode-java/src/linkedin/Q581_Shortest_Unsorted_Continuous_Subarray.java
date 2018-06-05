package linkedin;

import java.util.Arrays;

public class Q581_Shortest_Unsorted_Continuous_Subarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        Arrays.sort(sorted);
        int l = 0, r = nums.length-1;
        while (l < nums.length && nums[l] == sorted[l]) {
            l++;
        }
        while (r > l && nums[r] == sorted[r]) {
            r--;
        }
        return r-l+1;
    }

}
