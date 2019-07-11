package Y2019.Q0001_Q0300;

public class Q0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{bsearch_l(nums, target), bsearch_r(nums, target)};
    }

    private int bsearch_l(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l] == target ? l : -1;
    }

    private int bsearch_r(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = r - (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return nums[r] == target ? r : -1;
    }

}
