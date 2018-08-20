package archive.linkedin;

public class Q081_Search_in_Rotated_Sorted_Array_II {

    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return true;
            }

            // the only difference from Q033, tricky case, just update left and right
            if(nums[l] == nums[m] && nums[r] == nums[m]) {
                l++;
                r--;
            } else if (nums[l] <= nums[m]) { // first half is in order
                if (nums[l] <= target && target < nums[m]) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            } else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
        }
        return false;
    }

}
