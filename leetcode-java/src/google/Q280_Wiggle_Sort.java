package google;

public class Q280_Wiggle_Sort {

    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i%2==1 && nums[i] < nums[i-1] || i%2==0 && nums[i] > nums[i-1])
                swap(nums, i, i-1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

}
