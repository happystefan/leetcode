package facebook;

import java.util.*;

public class Q347_Top_K_Frequent_Elements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        int[] cnts = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        int l = 0, h = cnts.length-1;
        while (l < h) {
            int i = partition(cnts, map, l, h);
            if (i == cnts.length-k) break;
            if (i < cnts.length-k) l = i+1;
            else h = i-1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = cnts.length-1; i >= cnts.length-k; i--) {
            result.add(cnts[i]);
        }
        return result;
    }

    private int partition(int[] nums, Map<Integer, Integer> map, int l, int h) {
        int i = l, j = h-1, pivot = map.get(nums[h]);
        while (i <= j) {
            if (map.get(nums[i]) > pivot) swap(nums, i, j--);
            else i++;
        }
        swap(nums, i, h);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
