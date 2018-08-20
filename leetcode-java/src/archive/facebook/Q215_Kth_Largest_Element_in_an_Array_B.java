package archive.facebook;

public class Q215_Kth_Largest_Element_in_an_Array_B {

    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findKthSmallest(int[] nums, int l, int h, int k) {
        while (l < h) {
            int i = partition(nums, l, h);
            if (i == k) {
                break;
            } else if (i < k) {
                l = i+1;
            } else {
                h = i-1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int h) {
        int i = l, j = h-1, pivot = nums[h];
        while (i <= j) {
            if (nums[i] > pivot) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
        swap(nums, i, h);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
