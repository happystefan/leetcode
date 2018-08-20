package archive.facebook;

public class Q283_Move_Zeroes {

    public void moveZeroes(int[] nums) {
        int i = 0, j  = 0;
        while (j < nums.length) {
            while(j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j < nums.length) {
                swap(nums, i, j);
            }
            i++;
            j++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
