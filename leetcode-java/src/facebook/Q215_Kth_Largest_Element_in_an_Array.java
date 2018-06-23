package facebook;

public class Q215_Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findKthSmallest(int[] nums, int l, int h, int k) {
        int i = l, j = h, pivot = nums[l];
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            if (i < j) swap(nums, i, j);
            while (i < j && nums[i] <= pivot) i++;
            if (i < j) swap(nums, i, j);
        }
        return i == k ? nums[i] : (i < k ? findKthSmallest(nums, i+1, h, k) : findKthSmallest(nums, l, i-1, k));
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
