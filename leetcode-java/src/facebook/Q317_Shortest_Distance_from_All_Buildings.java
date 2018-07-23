package facebook;

import java.util.*;

public class Q317_Shortest_Distance_from_All_Buildings {

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
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                int dist = bfs(grid, i, j, buildingNum);
                result = Math.min(result, dist);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int bfs(int[][] grid, int i, int j, int buildingNum) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{i, j});
        Set<String> visitedBuildings = new HashSet<>();
        int steps = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                int[] curr = Q.poll();
                int x = curr[0], y = curr[1];
                visited[x][y] = true;
                if (grid[x][y] == 1 && !visitedBuildings.contains(x+" "+y)) {
                    result += steps;
                    visitedBuildings.add(x+" "+y);
                }
                if (grid[x][y] == 1) {
                    continue;
                }
                for (int[] dir : dirs) {
                    int xx = x + dir[0], yy = y + dir[1];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy] || grid[xx][yy] == 2) {
                        continue;
                    }
                    Q.offer(new int[]{xx, yy});
                }
            }
            steps++;
        }
        return visitedBuildings.size() == buildingNum ? result : Integer.MAX_VALUE;
    }

}
