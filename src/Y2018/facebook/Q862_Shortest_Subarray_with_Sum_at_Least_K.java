package Y2018.facebook;

import java.util.ArrayDeque;

public class Q862_Shortest_Subarray_with_Sum_at_Least_K {

    public int shortestSubarray(int[] A, int K) {
        int[] sums = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sums[i + 1] = sums[i] + A[i];
        }
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            while (!Q.isEmpty() && sums[i] - sums[Q.peekFirst()] >= K) {
                result = Integer.min(result, i - Q.pollFirst());
            }
            while (!Q.isEmpty() && sums[i] <= sums[Q.peekLast()]) {
                Q.pollLast();
            }
            Q.addLast(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
