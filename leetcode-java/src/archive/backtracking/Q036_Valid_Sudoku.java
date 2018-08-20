package archive.backtracking;

import java.util.*;

public class Q036_Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> cubeSet= new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) return false;
                if (board[j][i] != '.' && !colSet.add(board[j][i])) return false;
                int ii = 3*(i/3), jj = 3*(i%3);
                if (board[ii+j/3][jj+j%3] != '.' && !cubeSet.add(board[ii+j/3][jj+j%3])) return false;
            }
        }
        return true;
    }

}

