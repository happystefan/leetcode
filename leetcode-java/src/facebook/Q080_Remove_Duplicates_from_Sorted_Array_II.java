package facebook;

public class Q080_Remove_Duplicates_from_Sorted_Array_II {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int k = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k == 0) {
                cnt = 1;
                nums[k++] = nums[i];
            } else if (nums[i] != nums[i-1]) {
                cnt = 1;
                nums[k++] = nums[i];
            } else if (nums[i] == nums[i-1]){
                cnt++;
                if (cnt <= 2) {
                    nums[k++] = nums[i];
                }
            }
        }
        return k;
    }

}
