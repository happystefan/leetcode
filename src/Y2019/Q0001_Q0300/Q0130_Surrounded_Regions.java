package Y2019.Q0001_Q0300;

public class Q0130_Surrounded_Regions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '+') board[i][j] = 'O';
            }
        }
        return;
    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        board[i][j] = '+';
        for (int[] dir : dirs) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n) continue;
            if (board[ii][jj] != 'O') continue;
            dfs(board, ii, jj);
        }
    }

}
