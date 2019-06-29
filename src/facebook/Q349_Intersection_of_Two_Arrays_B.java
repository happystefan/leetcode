package facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q349_Intersection_of_Two_Arrays_B {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums1[j]) {
                set.add(nums1[i]);
                i++;
                j++;
                while (i < nums1.length && nums1[i] == nums1[i - 1]) i++;
                while (j < nums2.length && nums2[j] == nums2[j - 1]) j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
                while (i < nums1.length && nums1[i] == nums1[i - 1]) i++;
            } else {
                j++;
                while (j < nums2.length && nums2[j] == nums2[j - 1]) j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (int num : set) result[k++] = num;
        return result;
    }

}
