package Y2019.Q0001_Q0300;

public class Q0079_Word_Search {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0, new boolean[m][n])) return true;
            }
        }
        return false;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean dfs(char[][] board, int i, int j, String word, int pos, boolean[][] seen) {
        if (pos == word.length()) return true;
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (word.charAt(pos) != board[i][j]) return false;
        if (seen[i][j]) return false;

        seen[i][j] = true;
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (dfs(board, ii, jj, word, pos + 1, seen)) return true;
        }
        seen[i][j] = false;
        return false;
    }

}
