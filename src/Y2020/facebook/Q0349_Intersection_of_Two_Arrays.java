package Y2020.facebook;

import java.util.HashSet;
import java.util.Set;

public class Q0349_Intersection_of_Two_Arrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        set1.retainAll(set2);
        int[] rslt = new int[set1.size()];
        int i = 0;
        for (int num : set1) rslt[i++] = num;
        return rslt;
    }

}
