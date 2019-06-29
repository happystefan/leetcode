package Y2018.facebook;

import java.util.*;

public class Q347_Top_K_Frequent_Elements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int num : map.keySet()) {
            Q.add(new int[]{num, map.get(num)});
        }
        List<Integer> result = new LinkedList<>();
        while (k-- > 0) {
            result.add(Q.poll()[0]);
        }
        return result;
    }

}
