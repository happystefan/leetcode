package linkedin;

public class Q035_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l;
    }

}
