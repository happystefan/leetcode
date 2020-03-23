package Y2020.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0350_Intersection_of_Two_Arrays_II {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> rslt = new LinkedList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                rslt.add(nums1[i]);
                i++;
                j++;
            }
        }
        return rslt.stream().mapToInt(Integer::intValue).toArray();
    }

}
