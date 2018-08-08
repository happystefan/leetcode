package backtracking;

import java.util.*;

public class Q052_N_Queens_II {

    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> antiDiag = new HashSet<>();
    int result = 0;
    public int totalNQueens(int n) {
        dfs(0, n);
        return result;
    }

    private void dfs(int row, int n) {
        if (row == n) {
            result++;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col)) {
                continue;
            }
            if (diag.contains(row+col)) {
                continue;
            }
            if (antiDiag.contains(row-col)) {
                continue;
            }
            cols.add(col);
            diag.add(row+col);
            antiDiag.add(row-col);
            dfs(row+1, n);
            cols.remove(col);
            diag.remove(row+col);
            antiDiag.remove(row-col);
        }
    }

}
