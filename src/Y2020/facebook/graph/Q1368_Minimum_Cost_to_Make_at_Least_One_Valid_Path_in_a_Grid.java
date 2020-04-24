package Y2020.facebook.graph;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q1368_Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid {

    public int minCost(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length, n = grid[0].length;
        Queue<int[]> Q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        Q.add(new int[]{0, 0, 0});
        while (!Q.isEmpty()) {
            int[] pair = Q.poll();
            int x = pair[0], y = pair[1], c = pair[2];
            visited[x][y] = true;
            if (x == m - 1 && y == n - 1) return c;
            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int xx = x + dir[0];
                int yy = y + dir[1];
                int cc = c + (i + 1 == grid[x][y] ? 0 : 1);
                if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy]) continue;
                Q.add(new int[]{xx, yy, cc});
            }
        }
        return 0;
    }

}
