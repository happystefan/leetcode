package Y2018.facebook;

public class Q088_Merge_Sorted_Array {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1, j = n - 1;
        while (k >= 0) {
            if (i == -1) {
                nums1[k--] = nums2[j--];
            } else if (j == -1) {
                nums1[k--] = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

}
