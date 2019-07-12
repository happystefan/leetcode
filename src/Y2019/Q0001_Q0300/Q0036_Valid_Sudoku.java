package Y2019.Q0001_Q0300;

public class Q0036_Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        int[][] rows = new int[n][n];
        int[][] cols = new int[n][n];
        int[][][] boxs = new int[3][3][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                rows[i][num]++;
                cols[j][num]++;
                boxs[i / 3][j / 3][num]++;
                if (rows[i][num] > 1 || cols[j][num] > 1 || boxs[i / 3][j / 3][num] > 1) return false;
            }
        }
        return true;
    }

}
