package Y2020.facebook;

import java.util.*;

public class Q0347_Top_K_Frequent_Elements {

    class solution1_heap {

        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
            PriorityQueue<Integer> Q = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
            for (int num : map.keySet()) {
                Q.add(num);
                if (Q.size() > k) Q.poll();
            }
            List<Integer> rslt = new LinkedList<>();
            while (!Q.isEmpty()) rslt.add(Q.poll());
            return rslt;
        }

    }

    class solution_quick_sort {

        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
            List<int[]> pairs = new ArrayList<>();
            for (int num : map.keySet()) {
                pairs.add(new int[]{num, map.get(num)});
            }
            int l = 0, r = pairs.size() - 1;
            while (l < r) {
                int i = partition(pairs, l, r);
                if (i < k) l = i + 1;
                else if (i > k) r = i - 1;
                else break;
            }
            List<Integer> rslt = new LinkedList<>();
            for (int i = 0; i < k; i++) rslt.add(pairs.get(i)[0]);
            return rslt;
        }

        private int partition(List<int[]> pairs, int l, int r) {
            int[] pivot = pairs.get(r);
            int i = 0, j = r - 1;
            while (i <= j) {
                if (pairs.get(i)[1] < pivot[1]) swap(pairs, i, j--);
                else i++;
            }
            swap(pairs, i, r);
            return i;
        }

        private void swap(List<int[]> pairs, int i, int j) {
            int[] tmp = pairs.get(i);
            pairs.set(i, pairs.get(j));
            pairs.set(j, tmp);
        }

    }

}
