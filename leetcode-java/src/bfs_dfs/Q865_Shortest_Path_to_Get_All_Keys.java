package bfs_dfs;

import java.util.*;

public class Q865_Shortest_Path_to_Get_All_Keys {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = grid[i].toCharArray();
        }
        int keymask = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Character.isUpperCase(map[i][j])) {
                    keymask |= (1 << (map[i][j]-'A'));
                }
            }
        }
        Queue<int[]> Q = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][1<<7];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '@') {
                    Q.offer(new int[]{i, j, 0});
                    visited[i][j][0] = true;
                    break;
                }
            }
        }
        int result = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                int[] pair = Q.poll();
                int i = pair[0], j = pair[1], picked = pair[2];
                // get all keys, return
                if (picked == keymask) {
                    return result;
                }
                for (int[] dir : dirs) {
                    int ii = i+dir[0], jj = j+dir[1];
                    if (ii < 0 || ii >= m || jj < 0 || jj >= n) { // outside the grid
                        continue;
                    }
                    if (Character.isLowerCase(map[ii][jj])) {  // pick up keys
                        picked |= (1 << (map[ii][jj]-'a'));
                    }
                    // wall or lock without key
                    if (map[ii][jj] == '#' || Character.isUpperCase(map[ii][jj]) && (picked & (1 << (map[ii][jj]-'A'))) == 0) {
                        continue;
                    }
                    // do not revisit a visited cell again without more keys;
                    if (visited[ii][jj][picked]) {
                        continue;
                    }
                    Q.offer(new int[]{ii, jj, picked});
                    visited[ii][jj][picked] = true;
                }
            }
            result++;
        }
        return -1;
    }

}
