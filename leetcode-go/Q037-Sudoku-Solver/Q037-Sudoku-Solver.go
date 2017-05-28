package Q037_Sudoku_Solver

var (
	chars  = []byte{'1', '2', '3', '4', '5', '6', '7', '8', '9'}
)

func solveSudoku(board [][]byte) {
	dfs(board, 0)
}

func dfs(board [][]byte, pos int) bool {
	if pos >= 81 {
		return true
	}

	i, j := pos/9, pos%9
	if board[i][j] != '.' {
		return dfs(board, pos+1)
	} else {
		for _, c := range chars {
			if isValid(board, i, j, c) {
				board[i][j] = c
				if dfs(board, pos+1) {
					return true
				} else {
					board[i][j] = '.'
				}
			}
		}
	}
	return false
}

func isValid(board [][]byte, i, j int, c byte) bool {
	for k := 0; k < 9 ; k++ {
		if board[i][k] == c {
			return false
		}
		if board[k][j] == c {
			return false
		}

		row, col := i/3, j/3
		for m := 3*row; m < 3*(row+1); m++ {
			for n := 3*col; n < 3*(col+1); n++ {
				if board[m][n] == c {
					return false
				}
			}
		}

	}
	return true
}
