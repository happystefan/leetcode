package Y2020.facebook.misc.monotonic_stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Q0862_Shortest_Subarray_with_Sum_at_Least_K {

    class solution_treemap {

        public int shortestSubarray(int[] A, int K) {
            if (A == null || A.length == 0) return 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, -1);
            int rslt = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
                Integer floor = map.floorKey(sum - K);
                while (floor != null) {
                    rslt = Math.min(rslt, i - map.get(floor));
                    map.remove(floor);
                    floor = map.floorKey(sum - K);
                }
                map.put(sum, i);
            }
            return rslt == Integer.MAX_VALUE ? -1 : rslt;
        }

    }

    class solution_monoqueue {

        public int shortestSubarray(int[] A, int K) {
            if (A == null || A.length == 0) return 0;
            int[] sums = new int[A.length + 1];
            for (int i = 0; i < A.length; i++) sums[i + 1] = sums[i] + A[i];
            Deque<Integer> Q = new LinkedList<>();
            int rslt = Integer.MAX_VALUE;
            for (int i = 0; i < sums.length; i++) {
                while (!Q.isEmpty() && sums[i] <= sums[Q.peekLast()]) Q.pollLast();
                while (!Q.isEmpty() && sums[i] - sums[Q.peekFirst()] >= K) rslt = Math.min(rslt, i - Q.pollFirst());
                Q.addLast(i);
            }
            return rslt == Integer.MAX_VALUE ? -1 : rslt;
        }

    }

}
