package Y2020.facebook.misc;

public class Q1060_Missing_Element_in_Sorted_Array {

    public int missingElement(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            int i = numOfMissing(nums, m);
            if (i < k) l = m + 1;
            else r = m;
        }
        return nums[l - 1] + k - numOfMissing(nums, l - 1);
    }

    private int numOfMissing(int[] nums, int idx) {
        return nums[idx] - nums[0] - idx;
    }

}
