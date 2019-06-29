package Y2018.Q001_Q300;

public class Q153_Find_Minimum_in_Rotated_Sorted_Array {

    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] > nums[h]) l = m + 1;
            else h = m;
        }
        return nums[l];
    }

}
