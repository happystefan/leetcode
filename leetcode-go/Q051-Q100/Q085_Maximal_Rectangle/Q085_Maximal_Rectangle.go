package Q085_Maximal_Rectangle

func maximalRectangle(matrix [][]byte) int {
	if len(matrix) == 0 {
		return 0
	}
	heights := make([]int, len(matrix[0]))
	for i := 0; i < len(matrix[0]); i++ {
		if matrix[0][i] == '0' {
			heights[i] = 0
		} else {
			heights[i] = 1
		}
	}
	heights = append(heights, 0) // add a sentinel to the end

	ans := largestRectangleArea(heights)
	for i := 1; i < len(matrix); i++ {
		for j := 0; j < len(heights)-1; j++ {
			if matrix[i][j] == '0' {
				heights[j] = 0
			} else {
				heights[j] += 1
			}
		}
		ans = max(ans, largestRectangleArea(heights))
	}
	return ans
}

func largestRectangleArea(heights []int) int {
	stack := []int{}
	ans := 0
	for i := 0; i < len(heights); i++ {
		for len(stack) > 0 && heights[stack[len(stack)-1]] >= heights[i] {
			h := heights[stack[len(stack)-1]]
			stack = stack[:len(stack)-1]

			x := -1
			if len(stack) > 0 {
				x = stack[len(stack)-1]
			}
			ans = max(ans, h*(i-x-1))
		}
		stack = append(stack, i)
	}
	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
