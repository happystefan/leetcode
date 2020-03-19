package Y2020.facebook;

public class Q0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int l = bsearch_l(nums, target);
        int r = bsearch_r(nums, target);
        return new int[]{l, r};
    }

    private int bsearch_l(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = r - (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return nums[l] == target ? l : -1;
    }

    private int bsearch_r(int[] nums, int target) {
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

}
