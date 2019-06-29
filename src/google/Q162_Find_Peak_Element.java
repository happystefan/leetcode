package google;

public class Q162_Find_Peak_Element {

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 2;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < nums[m + 1]) l = m + 1;
            else r = m;
        }
        return l;
    }

}
