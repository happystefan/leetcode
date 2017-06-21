package Q059_Spiral_Matrix_II

func generateMatrix(n int) [][]int {
	ans := make([][]int, n)
	for i := range ans {
		ans[i] = make([]int, n)
	}
	rbegin, rend := 0, n-1
	cbegin, cend := 0, n-1
	num := 1
	for rbegin <= rend || cbegin <= cend {
		// go right
		if rbegin <= rend {
			for j := cbegin; j <= cend; j++ {
				ans[rbegin][j] = num
				num++
			}
			rbegin++
		}
		// go down
		if cbegin <= cend {
			for i := rbegin; i <= rend; i++ {
				ans[i][cend] = num
				num++
			}
			cend--
		}
		// go left
		if rbegin <= rend {
			for j := cend; j >= cbegin; j-- {
				ans[rend][j] = num
				num++
			}
			rend--
		}
		// go up
		if cbegin <= cend {
			for i := rend; i >= rbegin; i-- {
				ans[i][cbegin] = num
				num++
			}
			cbegin++
		}
	}

	return ans
}
