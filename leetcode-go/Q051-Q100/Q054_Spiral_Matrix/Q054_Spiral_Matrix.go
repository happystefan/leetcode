package Q054_Spiral_Matrix

func spiralOrder(matrix [][]int) []int {
	ans := []int{}
	if len(matrix) == 0 {
		return ans
	}
	rbeign, rend := 0, len(matrix)-1
	cbegin, cend := 0, len(matrix[0])-1
	for rbeign <= rend || cbegin <= cend {
		// go right
		if rbeign <= rend {
			for j := cbegin; j <= cend; j++ {
				ans = append(ans, matrix[rbeign][j])
			}
			rbeign++
		}
		// go down
		if cbegin <= cend {
			for i := rbeign; i <= rend; i++ {
				ans = append(ans, matrix[i][cend])
			}
			cend--
		}
		// go left
		if rbeign <= rend {
			for j := cend; j >= cbegin; j-- {
				ans = append(ans, matrix[rend][j])
			}
			rend--
		}
		// go up
		if cbegin <= cend {
			for i := rend; i >= rbeign; i-- {
				ans = append(ans, matrix[i][cbegin])
			}
			cbegin++
		}
	}
	return ans
}
