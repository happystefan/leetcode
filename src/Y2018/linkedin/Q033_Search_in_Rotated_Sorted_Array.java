package Y2018.linkedin;

public class Q033_Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = nums[m] < nums[0] == target < nums[0]
                    ? nums[m]
                    : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (val < target) {
                l++;
            } else if (val > target) {
                r--;
            } else {
                return m;
            }
        }
        return -1;
    }

}
