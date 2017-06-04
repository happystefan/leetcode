package Q051_N_Queens

func solveNQueens(n int) [][]string {
	board := make([][]byte, n)
	for i := range board {
		board[i] = make([]byte, n)
		for j := range board[i] {
			board[i][j] = '.'
		}
	}
	ans := [][]string{}
	dfs(board, 0, n, &ans)
	return ans
}

func dfs(board [][]byte, row, n int, ans *[][]string) {
	if row == n {
		tmp := make([]string, n)
		for i := 0; i < n; i++ {
			tmp[i] = string(board[i])
		}
		*ans = append(*ans, tmp)
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
