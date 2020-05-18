package Y2020.facebook.misc;

public class Q0081_Search_in_Rotated_Sorted_Array_II {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            if (nums[m] > nums[r]) {
                if (nums[l] <= target && target < nums[m]) r = m;
                else l = m + 1;
            } else if (nums[m] < nums[r]) {
                if (nums[m] < target && target <= nums[r]) l = m + 1;
                else r = m;
            } else {
                r--;
            }
        }
        return nums[l] == target;
    }

}
