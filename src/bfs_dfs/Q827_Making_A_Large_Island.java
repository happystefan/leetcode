package bfs_dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q827_Making_A_Large_Island {

    int[][] island; // (i, j) -> islandNum lookup table;
    Map<Integer, Integer> map = new HashMap<>();
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        island = new int[m][n];
        int cnt = 1;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] != 0 || grid[i][j] == 0) {
                    continue;
                }
                int[] area = new int[1];
                dfs(grid, i, j, cnt, area);
                map.put(cnt, area[0]);
                cnt++;
                result = Math.max(result, area[0]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                Set<Integer> set = new HashSet<>();
                for (int[] dir : dirs) {
                    int ii = i + dir[0], jj = j + dir[1];
                    if (ii < 0 || ii >= grid.length || jj < 0 || jj >= grid[0].length || grid[ii][jj] == 0) {
                        continue;
                    }
                    set.add(island[ii][jj]);
                }
                int area = 1;
                for (int num : set) {
                    area += map.get(num);
                }
                result = Math.max(result, area);
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j, int cnt, int[] area) {
        island[i][j] = cnt;
        area[0] += 1;
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= grid.length || jj < 0 || jj >= grid[0].length || grid[ii][jj] == 0 || island[ii][jj] != 0) {
                continue;
            }
            dfs(grid, ii, jj, cnt, area);
        }
    }

}
