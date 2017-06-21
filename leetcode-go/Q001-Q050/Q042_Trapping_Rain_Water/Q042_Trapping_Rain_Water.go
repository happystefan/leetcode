package Q042_Trapping_Rain_Water

func trap(height []int) int {
	l, r := 0, len(height)-1
	lmax, rmax := 0, 0
	ans := 0
	for l < r {
		lmax = max(lmax, height[l])
		rmax = max(rmax, height[r])
		if lmax < rmax {
			ans += lmax-height[l]
			l++
		} else {
			ans += rmax-height[r]
			r--
		}
	}
	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}