package Q052_N_Queens_II

func totalNQueens(n int) int {
	board := make([][]byte, n)
	for i := range board {
		board[i] = make([]byte, n)
		for j := range board[i] {
			board[i][j] = '.'
		}
	}
	ans := 0
	dfs(board, 0, n, &ans)
	return ans
}

func dfs(board [][]byte, row, n int, ans *int) {
	if row == n {
		*ans++
	}
	for i := 0; i < n; i++ {
		if isValid(board, row, i, n) {
			board[row][i] = 'Q'
			dfs(board, row+1, n, ans)
			board[row][i] = '.'
		}
	}
}

func isValid(board [][]byte, x, y, n int) bool {
	for i := 0; i < x; i++ {
		if board[i][y] == 'Q' {
			return false
		}
	}
	for i, j := x-1, y-1; i >= 0 && j >= 0; {
		if board[i][j] == 'Q' {
			return false
		}
		i--
		j--
	}
	for i, j := x-1, y+1; i >= 0 && j < n; {
		if board[i][j] == 'Q' {
			return false
		}
		i--
		j++
	}
	return true
}
