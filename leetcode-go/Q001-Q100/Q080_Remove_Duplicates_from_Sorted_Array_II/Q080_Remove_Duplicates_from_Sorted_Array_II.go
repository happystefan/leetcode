package Q080_Remove_Duplicates_from_Sorted_Array_II

func removeDuplicates(nums []int) int {
	if len(nums) < 3 {
		return len(nums)
	}
	idx := 1
	for i := 2; i < len(nums); i++ {
		if !(nums[i] == nums[idx] && nums[i] == nums[idx-1]) {
			idx++
			nums[idx] = nums[i]
		}
	}
	return idx
}
