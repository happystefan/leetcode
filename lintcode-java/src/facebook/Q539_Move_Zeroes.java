package facebook;

public class Q539_Move_Zeroes {

    public void moveZeroes(int[] nums) {
        // write your code here
        int i = 0, j = 0;
        while(i < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            if (i == nums.length) {
                return;
            }
            j = i+1;
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j == nums.length) {
                return;
            }

            // swap
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
        }
    }

}
