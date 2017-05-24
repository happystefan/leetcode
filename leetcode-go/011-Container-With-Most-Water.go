package leetcode_go

func maxArea(height []int) int {
	l, r := 0, len(height)-1
	ans := 0
	for l < r {
		h := min(height[l], height[r])
		if h*(r-l) > ans {
			ans = h * (r - l)
		}
		if height[l] <= h {
			l++
		}
		if height[r] <= h {
			r--
		}
	}
	return ans
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
