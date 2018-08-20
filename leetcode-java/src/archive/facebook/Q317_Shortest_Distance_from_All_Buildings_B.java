package archive.facebook;

import java.util.*;

public class Q317_Shortest_Distance_from_All_Buildings_B {

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int buildingNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                }
            }
        }
        int[][] dist = new int[m][n];
        int[][] bnum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                bfs(grid, i, j, dist, bnum);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                result = Math.min(result, bnum[i][j] == buildingNum ? dist[i][j] : Integer.MAX_VALUE);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void bfs(int[][] grid, int i, int j, int[][] dist, int[][] bnum) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{i, j});
        int steps = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                int[] curr = Q.poll();
                int x = curr[0], y = curr[1];
                if (grid[x][y] == 0) {
                    dist[x][y] += steps;
                    bnum[x][y] += 1;
                }
                for (int[] dir : dirs) {
                    int xx = x + dir[0], yy = y + dir[1];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy] || grid[xx][yy] != 0) {
                        continue;
                    }
                    Q.offer(new int[]{xx, yy});
                    visited[xx][yy] = true;
                }
            }
            steps++;
        }
    }

}

