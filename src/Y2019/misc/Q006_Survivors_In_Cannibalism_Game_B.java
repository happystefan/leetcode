package Y2019.misc;

import java.util.LinkedList;
import java.util.Queue;

public class Q006_Survivors_In_Cannibalism_Game_B {

    public int numberOfSurvivors(char[][] board) {
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
