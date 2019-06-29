package backtracking;

public class Q052_N_Queens_II_B {


    boolean[] cols;
    boolean[] diag;
    boolean[] antiDiag;
    int result = 0;

    public int totalNQueens(int n) {
        cols = new boolean[n];
        diag = new boolean[2 * n];
        antiDiag = new boolean[2 * n];
        dfs(0, n);
        return result;
    }

    private void dfs(int row, int n) {
        if (row == n) {
            result++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col]) {
                continue;
            }
            if (diag[row - col + n]) {
                continue;
            }
            if (antiDiag[row + col]) {
                continue;
            }
            cols[col] = true;
            diag[row - col + n] = true;
            antiDiag[row + col] = true;
            dfs(row + 1, n);
            cols[col] = false;
            diag[row - col + n] = false;
            antiDiag[row + col] = false;
        }
    }

}
