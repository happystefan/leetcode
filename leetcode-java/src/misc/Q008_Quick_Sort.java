package misc;

public class Q008_Quick_Sort {

    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi, pivot = nums[hi];
        while (i < j)
            if (nums[i++] > pivot) swap(nums, --i, --j);
        swap(nums, i, hi);
        return i;
        /* version 2:
        int i = lo, j = hi-1, pivot = nums[hi];
        while (i <= j) {
            if (nums[i] > pivot) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
        swap(nums, i, hi);
        return i;
        */

        /* version 3:
        int i = lo, j = hi, pivot = nums[hi];
        while (i < j) {
            if (nums[i] > pivot) {
                swap(nums, i, --j);
            } else {
                i++;
            }
        }
        swap(nums, i, hi);
        return i;
        */

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int idx = partition(nums, lo, hi);
        sort(nums, lo, idx-1);
        sort(nums, idx+1, hi);
    }

    public void sort(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

}
