package Y2019.Q0001_Q0300;

public class Q0088_Merge_Sorted_Array {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        int i = m - 1, j = n - 1;
        while (j >= 0) {
            nums1[pos--] = i == -1 || nums2[j] > nums1[i] ? nums2[j--] : nums1[i--];
        }
        return;
    }

}
