package Y2018.sort;

import java.util.HashSet;
import java.util.Set;

public class Q349_Intersection_of_Two_Arrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }

}
