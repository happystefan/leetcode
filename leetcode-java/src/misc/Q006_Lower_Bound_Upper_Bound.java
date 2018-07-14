package misc;

public class Q006_Lower_Bound_Upper_Bound {

    public int lower_bound(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] < target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l;
    }

    public int upper_bound(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] <= target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l;
    }
    
}
