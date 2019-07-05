package Y2019.misc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q006_Survivors_In_Cannibalism_Game {
    /*
    Given an 2D board, count the smallest possible number of survivors when a cannibalism game end.
    Players are represented with ’*’s, empty slots are represented with ’.’s.
    You may assume the following rules in cannibalism game:
       * You receive a valid board, made of only players or empty slots;
       * If player A and player B are on the same row or same, one player will eat another and
         only one of them will survive;
    */

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: dfs
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int numberOfSurvivors(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return 0;
        }
        int m = board.length, n = board[0].length;
        List<Integer>[] rowIndex = new List[m];
        List<Integer>[] colIndex = new List[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowIndex[i] == null) rowIndex[i] = new LinkedList<>();
                if (colIndex[j] == null) colIndex[j] = new LinkedList<>();
                if (board[i][j] == '.') continue;
                rowIndex[i].add(j);
                colIndex[j].add(i);
            }
        }
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (visited[i][j]) continue;
                dfs(i, j, visited, rowIndex, colIndex);
                result++;
            }
        }
        return result;
    }

    private void dfs(int i, int j, boolean[][] visited, List<Integer>[] rowIndex, List<Integer>[] colIndex) {
        visited[i][j] = true;
        for (int jj : rowIndex[i]) {
            if (!visited[i][jj]) dfs(i, jj, visited, rowIndex, colIndex);
        }
        for (int ii : colIndex[j]) {
            if (!visited[ii][j]) dfs(ii, j, visited, rowIndex, colIndex);
        }
    }


    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: bfs
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int numberOfSurvivors_BFS(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return 0;
        }
        int m = board.length, n = board[0].length;
        boolean[] rowVisited = new boolean[m];
        boolean[] colVisited = new boolean[n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (rowVisited[i] || colVisited[j]) continue;
                bfs(board, i, j, rowVisited, colVisited);
                result++;
            }
        }
        return result;
    }

    private void bfs(char[][] board, int row, int col, boolean[] rowVisited, boolean[] colVisited) {
        int m = board.length, n = board[0].length;
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{row, col});
        while (!Q.isEmpty()) {
            int[] pair = Q.poll();
            int i = pair[0], j = pair[1];
            if (!rowVisited[i]) {
                for (int jj = 0; jj < n; jj++) {
                    if (board[i][jj] == '.') continue;
                    Q.add(new int[]{i, jj});
                }
                rowVisited[i] = true;
            }
            if (!colVisited[j]) {
                for (int ii = 0; ii < m; ii++) {
                    if (board[ii][j] == '.') continue;
                    Q.add(new int[]{ii, j});
                }
                colVisited[j] = true;
            }
        }
    }

}
