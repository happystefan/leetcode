package Y2019.Q0001_Q0300;

public class Q0080_Remove_Duplicates_from_Sorted_Array_II {

    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] == nums[i - 1]) cnt++;
            else cnt = 1;
            if (cnt <= 2) nums[pos++] = nums[i];
        }
        return pos;
    }

}
