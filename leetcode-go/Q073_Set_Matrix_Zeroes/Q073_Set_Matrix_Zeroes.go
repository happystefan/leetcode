package Q073_Set_Matrix_Zeroes

func setZeroes(matrix [][]int) {
	m, n := len(matrix), len(matrix[0])
	ii, jj := 1, 1
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if matrix[i][j] != 0 {
				continue
			}
			matrix[i][0] = 0
			matrix[0][j] = 0
			if i == 0 {
				ii = 0
			}
			if j == 0 {
				jj = 0
			}
		}
	}
	for i := 1; i < m; i++ {
		if matrix[i][0] != 0 {
			continue
		}
		for j := 1; j < n; j++ {
			matrix[i][j] = 0
		}
	}
	for j := 1; j < n; j++ {
		if matrix[0][j] != 0 {
			continue
		}
		for i := 1; i < m; i++ {
			matrix[i][j] = 0
		}
	}

	if ii == 0 {
		for j := 0; j < n; j++ {
			matrix[0][j] = 0
		}

	}
	if jj == 0 {
		for i := 0; i < m; i++ {
			matrix[i][0] = 0
		}
	}
}
