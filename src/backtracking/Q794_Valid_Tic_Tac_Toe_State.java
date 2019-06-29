package backtracking;

public class Q794_Valid_Tic_Tac_Toe_State {

    public boolean validTicTacToe(String[] board) {
        int n = board.length;
        char[][] ss = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            ss[i] = board[i].toCharArray();
        }
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diag = 0;
        int antiDiag = 0;
        int turns = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int delta = ss[i][j] == 'X' ? 1 : (ss[i][j] == 'O' ? -1 : 0);
                rows[i] += delta;
                cols[j] += delta;
                if (i == j) diag += delta;
                if (i + j == n - 1) antiDiag += delta;
                turns += delta;
            }
        }
        boolean xwin = rows[0] == n || rows[1] == n || rows[2] == n ||
                cols[0] == n || cols[1] == n || cols[2] == n ||
                diag == n || antiDiag == n;
        boolean owin = rows[0] == -n || rows[1] == -n || rows[2] == -n ||
                cols[0] == -n || cols[1] == -n || cols[2] == -n ||
                diag == -n || antiDiag == -n;
        if (xwin && turns == 0 || owin && turns == 1) {
            return false;
        }
        return (turns == 0 || turns == 1) && (!xwin || !owin);
    }

}
