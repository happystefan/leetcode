package Q011_Container_With_Most_Water

// solution 1: brute force
func maxArea(height []int) int {
	ans := 0
	for i := 0; i < len(height)-1; i++ {
		for j := i + 1; j < len(height); j++ {
			if min(height[j], height[i])*(j-i) > ans {
				ans = min(height[j], height[i]) * (j - i)
			}
		}
	}
	return ans
}

// solution 2: brute force with prune
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
