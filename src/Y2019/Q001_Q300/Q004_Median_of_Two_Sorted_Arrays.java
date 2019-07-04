package Y2019.Q001_Q300;

public class Q004_Median_of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 1) {
            return topK(nums1, nums2, 0, 0, n / 2 + 1);
        } else {
            return 0.5 * topK(nums1, nums2, 0, 0, n / 2) +
                    0.5 * topK(nums1, nums2, 0, 0, n / 2 + 1);
        }
    }

    private double topK(int[] nums1, int[] nums2, int s1, int s2, int k) {
        if (s1 >= nums1.length) return nums2[s2 + k - 1];
        if (s2 >= nums2.length) return nums1[s1 + k - 1];
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);
        int idx1 = s1 + k / 2 - 1, idx2 = s2 + k / 2 - 1;
        int m1 = (idx1 < nums1.length) ? nums1[idx1] : Integer.MAX_VALUE;
        int m2 = (idx2 < nums2.length) ? nums2[idx2] : Integer.MAX_VALUE;
        return m1 < m2 ? topK(nums1, nums2, s1 + k / 2, s2, k - k / 2) :
                topK(nums1, nums2, s1, s2 + k / 2, k - k / 2);
    }

}
