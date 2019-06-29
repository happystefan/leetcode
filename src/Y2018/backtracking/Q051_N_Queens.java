package Y2018.backtracking;

import java.util.*;

public class Q051_N_Queens {

    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> antiDiag = new HashSet<>();
    List<List<String>> result = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(board, 0, n);
        return result;
    }

    private void dfs(char[][] board, int row, int n) {
        for (int col = 0; col < n; col++) {
            if (cols.contains(col)) {
                continue;
            }
            if (diag.contains(row + col)) {
                continue;
            }
            if (antiDiag.contains(row - col)) {
                continue;
            }
            if (row == n - 1) {
                board[row][col] = 'Q';
                convertToList(board);
                board[row][col] = '.';
                return;
            }
            cols.add(col);
            diag.add(row + col);
            antiDiag.add(row - col);
            board[row][col] = 'Q';
            dfs(board, row + 1, n);
            board[row][col] = '.';
            cols.remove(col);
            diag.remove(row + col);
            antiDiag.remove(row - col);
        }
    }

    private void convertToList(char[][] board) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }
        result.add(list);
    }

}
