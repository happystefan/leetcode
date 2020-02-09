package Y2019.facebook;

import java.util.*;

public class Q0350_Intersection_of_Two_Arrays_II {

    class solution1 {

        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            for (int num : nums1) map1.put(num, map1.getOrDefault(num, 0) + 1);
            for (int num : nums2) map2.put(num, map2.getOrDefault(num, 0) + 1);
            List<Integer> list = new LinkedList<>();
            for (int num : map1.keySet()) {
                int cnt = Math.min(map1.get(num), map2.getOrDefault(num, 0));
                while (cnt-- > 0) list.add(num);
            }
            return list.stream().mapToInt(k -> k).toArray();
        }

    }

    class solution2 {

        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> list = new LinkedList<>();
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] < nums2[i]) {
                    i++;
                } else {
                    j++;
                }
            }
            return list.stream().mapToInt(k -> k).toArray();
        }

    }

}
