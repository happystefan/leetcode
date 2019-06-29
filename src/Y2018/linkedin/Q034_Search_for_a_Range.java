package Y2018.linkedin;

public class Q034_Search_for_a_Range {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        if (nums[l] != target) {
            return result;
        }
        result[0] = l;

        r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2 + 1;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        result[1] = r;
        return result;
    }

}
