package Y2018.facebook.rotated_sorted_array;

public class Q154_Find_Minimum_in_Rotated_Sorted_Array_II {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) l = m + 1;
            else if (nums[m] == nums[r]) r--;
            else r = m;
        }
        return nums[l];
    }

}
