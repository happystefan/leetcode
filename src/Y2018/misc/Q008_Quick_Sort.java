package Y2018.misc;

import java.util.Random;

public class Q008_Quick_Sort {

    private Random random = new Random();

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * one-way partition version 1
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    private int partition_v1(int[] nums, int lo, int hi) {
        int i = lo, j = hi, pivot = nums[hi];
        while (i < j)
            if (nums[i++] > pivot) swap(nums, --i, --j);
        swap(nums, i, hi);
        return i;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * one-way partition version 2
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    private int partition_v2(int[] nums, int lo, int hi) {
        int i = lo, j = hi - 1, pivot = nums[hi];
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

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * one-way partition version 3
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    private int partition_v3(int[] nums, int lo, int hi) {
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
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * two-way partition
     *
     *------------------------------------------------------------------------------------------------------------------
     */

    private void sort_twoway(int[] nums, int l, int r) {
        int pivot = nums[l + random.nextInt(r - l + 1)];
        int ll = l, rr = r;
        while (ll <= rr) {
            while (ll <= rr && nums[ll] < pivot) ll++;
            while (ll <= rr && nums[ll] > pivot) rr--;
            if (ll <= rr) {
                swap(nums, ll, rr);
                ll++;
                rr--;
            }
        }
        sort_twoway(nums, l, rr);
        sort_twoway(nums, ll, r);
    }

    private void sort_oneway(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int idx = partition_v1(nums, lo, hi);
        sort_oneway(nums, lo, idx - 1);
        sort_oneway(nums, idx + 1, hi);
    }

    public void sort(int[] nums) {
        sort_oneway(nums, 0, nums.length - 1);
        sort_twoway(nums, 0, nums.length - 1);
    }

}
