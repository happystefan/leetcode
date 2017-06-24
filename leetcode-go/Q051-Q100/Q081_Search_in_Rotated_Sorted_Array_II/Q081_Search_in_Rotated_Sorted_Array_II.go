package Q081_Search_in_Rotated_Sorted_Array_II

func search(nums []int, target int) bool {
	l, h := 0, len(nums)-1
	for l <= h {
		m := (l + h) / 2

		if nums[m] == target {
			return true
		}
		if nums[l] < nums[m] {
			if target >= nums[l] && target < nums[m] {
				h = m //- 1
			} else {
				l = m + 1
			}
		} else if nums[l] > nums[m] {
			if target > nums[m] && target <= nums[h] {
				l = m + 1
			} else {
				h = m //- 1
			}
		} else {
			l++
			//h--
		}
	}
	return false
}
