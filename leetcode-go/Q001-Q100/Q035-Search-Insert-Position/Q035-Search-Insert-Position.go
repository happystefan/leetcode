package Q035_Search_Insert_Position

func searchInsert(nums []int, target int) int {
	if nums[0] >= target {
		return 0
	}

	i := 0
	for ; i < len(nums); i++ {
		if nums[i] >= target {
			break
		}
	}
	return i
}
