package facebook;

public class Q123_Word_Search {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                boolean[][] visited = new boolean[board.length][board[0].length];
                visited[i][j] = true;
                if (dfs(board, i, j, word, 1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean dfs(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
        if (k >= word.length()) {
            return true;
        }
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length) {
                continue;
            }
            if (board[ni][nj] != word.charAt(k)) {
                continue;
            }
            if (visited[ni][nj]) {
                continue;
            }
            visited[ni][nj] = true;
            if (dfs(board, ni, nj, word, k+1, visited)) {
                return true;
            }
            visited[ni][nj] = false;
        }
        return false;
    }

}
