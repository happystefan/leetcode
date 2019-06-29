package facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q347_Top_K_Frequent_Elements_B {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer>[] bucket = new LinkedList[nums.length + 1];
        for (int num : map.keySet()) {
            int cnt = map.get(num);
            if (bucket[cnt] == null) bucket[cnt] = new LinkedList<>();
            bucket[cnt].add(num);
        }
        List<Integer> result = new LinkedList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) result.addAll(bucket[i]);
            if (result.size() >= k) break;
        }
        return result.subList(0, k);
    }

}
