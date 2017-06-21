package Q069_Sqrt_x_

func mySqrt(x int) int {
	if x == 0 {
		return 0
	}
	l, r := 1, x
	ans := 0
	for l <= r {
		m := (l + r) / 2
		if m*m <= x {
			l = m + 1
			ans = m
		} else {
			r = m - 1
		}
	}
	return ans
}
