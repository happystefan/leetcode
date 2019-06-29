package facebook.backtracking;

public class Q079_Word_Search {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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

    private boolean dfs(char[][] board, int i, int j, String word, int pos, boolean[][] visited) {
        int m = board.length, n = board[0].length;
        if (pos == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return false;
        if (word.charAt(pos) != board[i][j]) return false;

        visited[i][j] = true;
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (dfs(board, ii, jj, word, pos + 1, visited)) return true;
        }
        visited[i][j] = false;
        return false;
    }

}
