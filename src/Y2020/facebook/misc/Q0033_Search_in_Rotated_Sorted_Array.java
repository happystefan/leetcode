package Y2020.facebook.misc;

public class Q0033_Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target <= nums[m]) r = m;
                else r = m + 1;
            } else {
                if (nums[m] <= target && target <= nums[r]) l = m;
                else r = m - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

}
