package Y2018.google;

public class Q348_Design_Tic_Tac_Toe {

    class TicTacToe {

        int[] r, c;
        int d, a; // diagonal and antidiagonal
        int n;

        /**
         * Initialize your data structure here.
         */
        public TicTacToe(int n) {
            r = new int[n];
            c = new int[n];
            this.n = n;
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         *
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         * @return The current winning condition, can be either:
         * 0: No one wins.
         * 1: Player 1 wins.
         * 2: Player 2 wins.
         */
        public int move(int row, int col, int player) {
            int sign = player == 1 ? 1 : -1;
            r[row] += sign;
            c[col] += sign;
            if (row == col) d += sign;
            if (row + col == n - 1) a += sign;
            if (Math.abs(r[row]) == n || Math.abs(c[col]) == n || Math.abs(d) == n || Math.abs(a) == n)
                return sign == 1 ? 1 : 2;
            return 0;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

}
