package Q084_Largest_Rectangle_in_Histogram

func largestRectangleArea(heights []int) int {
	if len(heights) == 0 {
		return 0
	}
	lessl, lessr := make([]int, len(heights)), make([]int, len(heights))
	lessl[0] = -1
	lessr[len(heights)-1] = len(heights)
	for i := 1; i < len(heights); i++ {
		p := i - 1
		for p >= 0 && heights[p] >= heights[i] {
			p = lessl[p]
		}
		lessl[i] = p
	}
	for i := len(heights) - 2; i >= 0; i-- {
		p := i + 1
		for p < len(heights) && heights[p] >= heights[i] {
			p = lessr[p]
		}
		lessr[i] = p
	}
	ans := 0
	for i := 0; i < len(heights); i++ {
		ans = max(ans, heights[i]*(lessr[i]-lessl[i]-1))
	}
	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
