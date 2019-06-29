package facebook;

public class Q079_Word_Search {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (word.charAt(pos) != board[row][col] || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < 4; i++) {
            int nrow = row + dirs[i][0];
            int ncol = col + dirs[i][1];
            if (dfs(board, visited, word, nrow, ncol, pos + 1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

}
