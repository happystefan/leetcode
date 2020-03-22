package Y2020.facebook;

public class Q0026_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        int pos = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) nums[pos++] = nums[i];
        }
        return pos;
    }

}
