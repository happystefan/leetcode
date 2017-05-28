//package Q029_Divide_Two_Integers
package main

import "math"

func divide(dividend int, divisor int) int {
	if divisor == 0 || dividend == math.MinInt32 && divisor == -1 {
		return math.MaxInt32
	}

	sign := dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0
	dvd, dvs := abs(dividend), abs(divisor)

	ans := 0
	for dvs <= dvd {
		tmp := dvs
		cnt := 1
		for dvd >= tmp<<1 {
			tmp <<= 1
			cnt <<= 1
		}
		dvd -= tmp
		ans += cnt
	}

	if sign {
		return ans
	}
	return 0 - ans
}

func abs(a int) int64 {
	if a > 0 {
		return int64(a)
	}
	return int64(0 - a)
}
