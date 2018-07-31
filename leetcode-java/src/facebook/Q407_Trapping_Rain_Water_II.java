package facebook;

import java.util.*;

public class Q407_Trapping_Rain_Water_II {

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0] == null || heightMap[0].length == 0) {
            return 0;
        }
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Q.offer(new int[]{i, 0, heightMap[i][0]});
            Q.offer(new int[]{i, n-1, heightMap[i][n-1]});
            visited[i][0] = true;
            visited[i][n-1] = true;
        }
        for (int j = 1; j < n-1; j++) {
            Q.offer(new int[]{0, j, heightMap[0][j]});
            Q.offer(new int[]{m-1, j, heightMap[m-1][j]});
            visited[0][j] = true;
            visited[m-1][j] = true;
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int result = 0;
        while (!Q.isEmpty()) {
            int[] triple = Q.poll();
            int i = triple[0], j = triple[1], h = triple[2];
            for (int[] dir : dirs) {
                int ii = i+dir[0], jj = j+dir[1];
                if (ii < 0 || ii >= m || jj < 0 || jj >= m || visited[ii][jj]) {
                    continue;
                }
                result += Math.max(0, h-heightMap[ii][jj]);
                Q.offer(new int[]{ii, jj, Math.max(heightMap[ii][jj], h)});
                visited[ii][jj] = true;
            }
        }
        return result;
    }

}
