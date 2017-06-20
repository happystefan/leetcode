package main //Q079_Word_Search

import "fmt"

func exist(board [][]byte, word string) bool {
	if len(board) == 0 {
		return len(word) == 0
	}

	m, n := len(board), len(board[0])
	visit := make([][]bool, m)
	for i := 0; i < m; i++ {
		visit[i] = make([]bool, n)
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			visit[i][j] = true
			if dfs(board, visit, i, j, []byte(word)) {
				return true
			}
			visit[i][j] = false
		}
	}

	return false
}

func dfs(board [][]byte, visit [][]bool, x, y int, word []byte) bool {
	if len(word) == 1 {
		return board[x][y] == word[0]
	}
	if board[x][y] != word[0] {
		return false
	}
	dirs := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	for i := 0; i < 4; i++ {
		xx := x + dirs[i][0]
		yy := y + dirs[i][1]
		if xx < 0 || xx > len(board)-1 || yy < 0 || yy > len(board[0])-1 {
			continue
		}
		if visit[xx][yy] {
			continue
		}
		visit[xx][yy] = true
		if dfs(board, visit, xx, yy, word[1:]) {
			return true
		}
		visit[xx][yy] = false
	}
	return false
}

func main() {
	board := [][]byte{
		[]byte("ABCE"),
		[]byte("SFCS"),
		[]byte("ADEE"),
	}
	fmt.Println(exist(board, "ABCCED"))
}
