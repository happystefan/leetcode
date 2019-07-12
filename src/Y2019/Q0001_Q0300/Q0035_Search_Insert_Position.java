package Y2019.Q0001_Q0300;

public class Q0035_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (nums[l] > target) return l;
        if (nums[r] < target) return nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

}
