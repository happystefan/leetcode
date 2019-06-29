package Y2018.facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q350_Intersection_of_Two_Arrays_II {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new LinkedList<>();
        for (int num : map1.keySet()) {
            int cnt = Math.min(map1.get(num), map2.getOrDefault(num, 0));
            while (cnt-- > 0) {
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
