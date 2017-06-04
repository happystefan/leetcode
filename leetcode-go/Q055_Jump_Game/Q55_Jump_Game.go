package Q055_Jump_Game

func canJump(nums []int) bool {
	maxpos := 0
	for i := range nums {
		if i > maxpos {
			return false
		}
		maxpos = max(maxpos, nums[i]+i)
	}
	return true
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
