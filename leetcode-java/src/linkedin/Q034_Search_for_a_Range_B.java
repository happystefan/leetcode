package linkedin;

public class Q034_Search_for_a_Range_B {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] == target) {
                int i = m, j = m;
                while (i >= 0 && nums[i] == nums[m]) {
                    i--;
                }
                while (j < nums.length && nums[j] == nums[m]) {
                    j++;
                }
                return new int[]{i+1, j-1};
            }
            if (nums[m] < target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return new int[]{-1, -1};
    }

}
