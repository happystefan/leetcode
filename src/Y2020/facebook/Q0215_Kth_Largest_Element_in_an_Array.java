package Y2020.facebook;

public class Q0215_Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int i = partition(nums, l, r);
            if (i > k) r = i - 1;
            else if (i < k) l = i + 1;
            else break;
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l, j = r - 1;
        while (i <= j) {
            if (nums[i] <= pivot) swap(nums, i, j--);
            else i++;
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
