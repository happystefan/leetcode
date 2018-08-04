package facebook;

public class Q026_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        int l = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            nums[l++] = nums[i];
        }
        return l;
    }

}
