package facebook;

public class Q101_Remove_Duplicates_from_Sorted_Array_II {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] == nums[i] && i > 0 && nums[j] == nums[i-1]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        return i+1;
    }

}
