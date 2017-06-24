package Q084_Largest_Rectangle_in_Histogram_B

func largestRectangleArea(heights []int) int {
	stack := []int{}
	ans := 0

	i := 0
	for i < len(heights) {
		if len(stack) == 0 || heights[i] >= heights[stack[len(stack)-1]] {
			stack = append(stack, i)
			i++
			continue
		}

		top := stack[len(stack)-1]
		stack = stack[:len(stack)-1]

		w := i
		if len(stack) != 0 {
			w = i - stack[len(stack)-1] - 1
		}
		ans = max(ans, w*heights[top])
	}

	for len(stack) != 0 {
		top := stack[len(stack)-1]
		stack = stack[:len(stack)-1]

		w := i
		if len(stack) != 0 {
			w = i - stack[len(stack)-1] - 1
		}
		ans = max(ans, w*heights[top])
	}

	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
