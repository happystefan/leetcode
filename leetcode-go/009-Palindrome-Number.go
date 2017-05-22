package leetcode_go

func isPalindrome(x int) bool {
	xx := x
	if x < 0 {
		return false
	}
	y := 0
	for x > 0 {
		y = y*10 + x%10
		x /= 10
	}
	return xx == y
}
