package Y2019.Q0001_Q0300;

public class Q0026_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) nums[++i] = nums[j];
        }
        return i + 1;
    }

}
