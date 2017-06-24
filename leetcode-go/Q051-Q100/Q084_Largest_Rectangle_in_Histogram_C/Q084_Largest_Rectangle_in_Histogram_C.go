package Q084_Largest_Rectangle_in_Histogram_C

func largestRectangleArea(heights []int) int {
	stack := []int{}
	ans := 0

	heights = append(heights, 0) // add a sentinel to the end
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
