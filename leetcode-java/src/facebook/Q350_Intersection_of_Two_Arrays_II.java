package facebook;

import java.util.*;

public class Q350_Intersection_of_Two_Arrays_II {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1) map1.put(num, map1.getOrDefault(num, 0)+1);
        for (int num : nums2) map2.put(num, map2.getOrDefault(num, 0)+1);
        List<Integer> list = new ArrayList<>();
        for (int num : map1.keySet()) {
            if (!map2.containsKey(num)) continue;
            for (int i = 0; i < Math.min(map1.get(num), map2.get(num)); i++) {
                list.add(num);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }

}
