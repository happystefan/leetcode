package Y2018.facebook;

public class Q080_Remove_Duplicates_from_Sorted_Array_II {

    public int removeDuplicates(int[] nums) {
        int cnt = 0, l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] == nums[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt == 1 || cnt == 2) {
                nums[l++] = nums[i];
            }
        }
        return l;
    }

}
