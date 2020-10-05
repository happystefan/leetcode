package Y2020.linkedin.algo_part2;

import java.util.BitSet;

public class Q021_Number_in_Sorted_List {

    public int searchInRotatedSortedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[l] <= nums[m]) { // first part is sorted
                if (target >= nums[l] && target <= nums[m]) r = m;
                else l = m + 1;
            } else {
                if (target >= nums[m] && target <= nums[r]) l = m;
                else r = m - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public boolean searchInRotatedSortedArrayWithDuplicates(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            // the only difference from Q033, tricky case, just update left and right
            if (nums[l] == nums[m] && nums[r] == nums[m]) {
                l++;
                r--;
            } else if (nums[l] <= nums[m]) { // first half is in order
                if (nums[l] <= target && target <= nums[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] <= target && target <= nums[r]) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
        }
        return nums[l] == target;
    }

}
