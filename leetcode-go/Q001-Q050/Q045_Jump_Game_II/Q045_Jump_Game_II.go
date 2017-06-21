package Q045_Jump_Game_II

func jump(nums []int) int {
	maxpos := 0
	curpos := 0
	step := 0
	for i := 0; i < len(nums)-1; i++ {
		maxpos = max(maxpos, nums[i]+i)
		if curpos == i {
			curpos = maxpos
			step++
		}
	}
	return step
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
