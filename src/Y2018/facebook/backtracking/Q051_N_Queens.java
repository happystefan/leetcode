package Y2018.facebook.backtracking;

import java.util.*;

public class Q051_N_Queens {

    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> antiDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        List<List<String>> result = new LinkedList<>();
        solve(result, board, 0, n);
        return result;
    }

    private void solve(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) {
            result.add(toList(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col)) continue;
            if (diag.contains(row - col)) continue;
            if (antiDiag.contains(row + col)) continue;
            board[row][col] = 'Q';
            cols.add(col);
            diag.add(row - col);
            antiDiag.add(row + col);
            solve(result, board, row + 1, n);
            board[row][col] = '.';
            cols.remove(col);
            diag.remove(row - col);
            antiDiag.remove(row + col);
        }
    }

    private List<String> toList(char[][] board) {
        List<String> result = new LinkedList<>();
        for (char[] row : board) result.add(new String(row));
        return result;
    }

}
