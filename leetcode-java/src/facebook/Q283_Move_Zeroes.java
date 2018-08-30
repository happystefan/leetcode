package facebook;

public class Q283_Move_Zeroes {

    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int num : nums) {
            if (num != 0) nums[k++] = num;
        }
        while (k < nums.length) nums[k++] = 0;
    }

}
