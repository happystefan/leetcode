package Y2018.backtracking;

public class Q036_Valid_Sudoku_B {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9]; //rows[5][0] means whether number 1('0'+1) in row 5 has appeared.
        int[][] cols = new int[9][9]; //cols[3][8] means whether number 9('8'+1) in col 3 has appeared.
        int[][][] blocks = new int[3][3][9];//blocks[0][2][5] means whether number '6' in block 0,2 (row 0~2,col 6~8) has appeared.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                if (rows[i][num]++ > 0) return false; //if the number has already appeared once, return false.
                if (cols[j][num]++ > 0) return false;
                if (blocks[i / 3][j / 3][num]++ > 0) return false;
            }
        }
        return true;
    }

}
