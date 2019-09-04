package Y2019.facebook;

import java.util.*;

public class Q0347_Top_K_Frequent_Elements {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: bucket sort
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
            Set<Integer>[] buckets = new HashSet[nums.length + 1];
            for (int num : map.keySet()) {
                int cnt = map.get(num);
                if (buckets[cnt] == null) buckets[cnt] = new HashSet<>();
                buckets[cnt].add(num);
            }
            List<Integer> result = new LinkedList<>();
            for (int i = buckets.length - 1; i >= 0; i--) {
                if (buckets[i] == null) continue;
                result.addAll(buckets[i]);
            }
            return result.subList(0, k);
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: Heap
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
            PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            for (int num : map.keySet()) {
                int cnt = map.get(num);
                Q.add(new int[]{num, cnt});
                if ((Q.size() > k)) Q.poll();
            }
            List<Integer> result = new LinkedList<>();
            while (!Q.isEmpty()) result.add(Q.poll()[0]);
            return result;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3: quick select
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution3 {

        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
            List<int[]> pairs = new ArrayList<>(map.size());
            for (int num : map.keySet()) pairs.add(new int[]{num, map.get(num)});
            int l = 0, r = pairs.size() - 1;
            int kk = map.size() - k;
            while (l < r) {
                int pi = partition(pairs, l, r);
                if (pi < kk) l = pi + 1;
                else if (pi > kk) r = pi - 1;
                else break;
            }
            List<Integer> result = new LinkedList<>();
            for (int i = kk; i < map.size(); i++) result.add(pairs.get(i)[0]);
            return result;
        }

        private int partition(List<int[]> list, int l, int r) {
            int i = l, j = r - 1, pivot = list.get(r)[1];
            while (i <= j) {
                if (list.get(i)[1] > pivot) {
                    swap(list, i, j);
                    j--;
                } else {
                    i++;
                }
            }
            swap(list, i, r);
            return i;
        }

        private void swap(List<int[]> list, int i, int j) {
            int[] tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        }

    }

}
