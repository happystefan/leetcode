package Y2018.facebook;

import java.util.PriorityQueue;

public class Q378_Kth_Smallest_Element_in_a_Sorted_Matrix {

    // k*log(N)
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            Q.offer(new int[]{i, 0, matrix[i][0]});
        }
        while (--k > 0) {
            int[] t = Q.poll();
            if (t[1] == n - 1) continue;
            Q.offer(new int[]{t[0], t[1] + 1, matrix[t[0]][t[1] + 1]});
        }
        return Q.peek()[2];
    }

}
