package facebook;

public class Q148_Sort_Colors {

    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length-1;
        while (j <= k) {
            while (i > j && j < nums.length) {
                j++;
            }
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
            } else if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else {
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}