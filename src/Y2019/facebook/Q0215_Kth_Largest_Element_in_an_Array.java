package Y2019.facebook;

public class Q0215_Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        int kk = nums.length - k;
        while (l < r) {
            int pi = partition(nums, l, r);
            if (pi < kk) l = pi + 1;
            else if (pi > kk) r = pi - 1;
            else break;
        }
        return nums[kk];
    }

    private int partition(int[] nums, int l, int r) {
        int i = 0, j = r - 1, pivot = nums[r];
        while (i <= j) {
            if (nums[i] > pivot) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
