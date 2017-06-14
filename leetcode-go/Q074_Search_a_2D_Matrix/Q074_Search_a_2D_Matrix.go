package Q074_Search_a_2D_Matrix

func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 {
		return false
	}
	m, n := len(matrix), len(matrix[0])
	l, h := 0, m*n-1
	for l <= h {
		mid := (l + h) / 2
		i, j := mid/n, mid%n
		if matrix[i][j] == target {
			return true
		}
		if matrix[i][j] < target {
			l = mid + 1
		} else {
			h = mid - 1
		}
	}
	return false
}
