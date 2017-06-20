package Q074_Search_a_2D_Matrix_C

func searchMatrix(matrix [][]int, target int) bool {
	if matrix == nil || len(matrix) == 0 {
		return false
	}
	i, j := 0, len(matrix)-1
	m, n := 0, len(matrix[0])-1
	for i <= j {
		rmid := (i + j) / 2
		if matrix[rmid][m] <= target && matrix[rmid][n] >= target {
			for m <= n {
				cmid := (m + n) / 2
				if matrix[rmid][cmid] == target {
					return true
				} else if matrix[rmid][cmid] > target {
					n = cmid - 1
				} else if matrix[rmid][cmid] < target {
					m = cmid + 1
				}
			}
			return false
		} else if matrix[rmid][m] > target {
			j = rmid - 1
		} else if matrix[rmid][n] < target {
			i = rmid + 1
		}
	}
	return false
}
