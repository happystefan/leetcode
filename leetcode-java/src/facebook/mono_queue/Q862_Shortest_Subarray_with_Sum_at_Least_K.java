package facebook.mono_queue;

import java.util.*;

public class Q862_Shortest_Subarray_with_Sum_at_Least_K {

    public int shortestSubarray(int[] A, int K) {
        int[] sums = new int[A.length+1];
        for (int i = 0; i < A.length; i++) {
            sums[i+1] = sums[i]+A[i];
        }
        int result = Integer.MAX_VALUE;
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        for (int i = 0; i < sums.length; i++) {
            while (!Q.isEmpty() && sums[i]-sums[Q.peekFirst()] >= K) result = Math.min(result, i-Q.pollFirst());
            while (!Q.isEmpty() && sums[i] <= sums[Q.peekLast()]) Q.pollLast();
            Q.addLast(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
