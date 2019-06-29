package Y2018.Q001_Q300;

public class Q154_Find_Minimum_in_Rotated_Sorted_Array_II {

    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] > nums[h]) l = m + 1;
            else if (nums[m] < nums[h]) h = m;
            else h--;
        }
        return nums[l];
    }

}
