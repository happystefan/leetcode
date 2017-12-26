package google;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q508_Wiggle_Sort {

    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i%2 == 1 && nums[i] < nums[i-1] || i%2 == 0 && nums[i] > nums[i-1]) swap(nums, i, i-1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

}