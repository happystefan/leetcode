package leetcode_go

import "math"

func reverse(x int) int {
	res := int64(0)
	for x != 0 {
		res = res*10 + int64(x%10)
		x /= 10
		if res > math.MaxInt32 || res < math.MinInt32 {
			return 0
		}
	}
	return int(res)
}
