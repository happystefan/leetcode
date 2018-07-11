package bfs_dfs;

import java.util.*;

public class Q130_Surrounded_Regions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    continue;
                }
                List<int[]> path = new LinkedList<>();
                if (dfs(board, i, j, path, new boolean[m][n])) {
                    continue;
                }
                for (int[] pair : path) {
                    board[pair[0]][pair[1]] = 'X';
                }
            }
        }
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private boolean dfs(char[][] board, int i, int j, List<int[]> path, boolean[][] visited) {
        int m = board.length, n = board[0].length;
        if (i == 0 || i == m-1 || j == 0 || j == n-1) {
            return true;
        }
        path.add(new int[]{i, j});
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int ii = i+dir[0], jj = j+dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n || board[ii][jj] == 'X' || visited[ii][jj]) {
                continue;
            }
            if (dfs(board, ii, jj, path, visited)) {
                return true;
            }
        }
        return false;
    }

}
