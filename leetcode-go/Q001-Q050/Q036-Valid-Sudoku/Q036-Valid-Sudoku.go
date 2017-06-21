package Q036_Valid_Sudoku

func isValidSudoku(board [][]byte) bool {
	rowNum, colNum := len(board), len(board[0])

	//  NOTE: take care of the following initialization
	rowMaps := make([]map[byte]bool, rowNum)
	colMaps := make([]map[byte]bool, colNum)
	subMaps := make([][]map[byte]bool, rowNum)
	for i := 0; i < rowNum; i++ {
		rowMaps[i] = map[byte]bool{}
	}
	for j := 0; j < colNum; j++ {
		colMaps[j] = map[byte]bool{}
	}
	for i := 0; i < rowNum; i++ {
		subMaps[i] = make([]map[byte]bool, colNum)
		for j := 0; j < colNum; j++ {
			subMaps[i][j] = map[byte]bool{}
		}
	}

	for i := 0; i < rowNum; i++ {
		for j := 0; j < colNum; j++ {
			c := board[i][j]
			if c == '.' {
				continue
			}

			if rowMaps[i][c] {
				return false
			}
			rowMaps[i][c] = true

			if colMaps[j][c] {
				return false
			}
			colMaps[j][c] = true

			if subMaps[i/3][j/3][c] {
				return false
			}
			subMaps[i/3][j/3][c] = true
		}
	}
	return true
}
