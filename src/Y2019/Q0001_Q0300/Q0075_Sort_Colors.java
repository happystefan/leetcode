package Y2019.Q0001_Q0300;

public class Q0075_Sort_Colors {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * version 1
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public void sortColors_v1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int l = 0, r = nums.length - 1;
        int i = 0;
        while (i <= r) {
            if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
            } else if (nums[i] == 0) {
                swap(nums, i, l);
                l++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            }
        }
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * version 2
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int l = 0, r = nums.length - 1;
        for (int i = 0; i <= r; i++) {
            if (nums[i] == 2) {
                swap(nums, i--, r--);
            } else if (nums[i] == 0) {
                swap(nums, i, l++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
