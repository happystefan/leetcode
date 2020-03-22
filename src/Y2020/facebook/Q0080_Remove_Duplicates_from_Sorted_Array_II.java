package Y2020.facebook;

public class Q0080_Remove_Duplicates_from_Sorted_Array_II {

    public int removeDuplicates(int[] nums) {
        int pos = 1, cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (cnt == 0 || cnt == 1) nums[pos++] = nums[i];
                cnt++;
            } else {
                cnt = 1;
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }

}
