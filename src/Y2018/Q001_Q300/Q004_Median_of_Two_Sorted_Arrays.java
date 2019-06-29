package Y2018.Q001_Q300;

/**
 * Created by mqliang on 5/27/17.
 */
public class Q004_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum = len1 + len2;

        return sum % 2 == 1 ? findKth(nums1, nums2, 0, 0, sum / 2 + 1) :
                (findKth(nums1, nums2, 0, 0, sum / 2) + findKth(nums1, nums2, 0, 0, sum / 2 + 1)) / 2;
    }

    public double findKth(int[] nums1, int[] nums2, int sz1, int sz2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (sz1 >= len1) {
            return nums2[sz2 + k - 1];
        }
        if (sz2 >= len2) {
            return nums1[sz1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[sz1], nums2[sz2]);
        }

        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        if (sz1 + k / 2 - 1 < len1) {
            a = nums1[sz1 + k / 2 - 1];
        }
        if (sz2 + k / 2 - 1 < len2) {
            b = nums2[sz2 + k / 2 - 1];
        }

        return a < b ? findKth(nums1, nums2, sz1 + k / 2, sz2, k - k / 2) : findKth(nums1, nums2, sz1, sz2 + k / 2, k - k / 2);
    }
}
