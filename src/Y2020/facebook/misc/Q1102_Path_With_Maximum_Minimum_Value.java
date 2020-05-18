package Y2020.facebook.misc;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1102_Path_With_Maximum_Minimum_Value {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumMinimumPath(int[][] A) {
        int m = A.length, n = A[0].length;
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        int[][] score = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(score[i], -1);
        Q.add(new int[]{0, 0, A[0][0]});
        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            int i = cur[0], j = cur[1], s = cur[2];
            for (int[] dir : dirs) {
                int ii = i + dir[0], jj = j + dir[1];
                if (ii < 0 || ii >= m || jj < 0 || jj >= n || score[ii][jj] != -1) continue;
                score[ii][jj] = Math.min(s, A[ii][jj]);
                if (ii == m - 1 && jj == n - 1) return score[ii][jj];
                Q.add(new int[]{ii, jj, score[ii][jj]});
            }
        }
        return -1;
    }

}
