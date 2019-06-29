package google;

public class Q004_Median_of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) return findk(nums1, nums2, 0, 0, len / 2 + 1);
        else return (findk(nums1, nums2, 0, 0, len / 2) + findk(nums1, nums2, 0, 0, len / 2 + 1)) * 0.5;
    }

    private double findk(int[] nums1, int[] nums2, int s1, int s2, int k) {
        if (s1 >= nums1.length) return nums2[s2 + k - 1];
        if (s2 >= nums2.length) return nums1[s1 + k - 1];
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        if (s1 + k / 2 - 1 < nums1.length) m1 = nums1[s1 + k / 2 - 1];
        if (s2 + k / 2 - 1 < nums2.length) m2 = nums2[s2 + k / 2 - 1];
        if (m1 < m2) {
            return findk(nums1, nums2, s1 + k / 2, s2, k - k / 2);
        } else {
            return findk(nums1, nums2, s1, s2 + k / 2, k - k / 2);
        }
    }

}
