package facebook;

public class Q100_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        return i;
    }


}
