package Q033_Search_in_Rotated_Sorted_Array_B

func search(nums []int, target int) int {
	l, h := 0, len(nums)-1
	for l <= h {
		m := (l + h) / 2

		if nums[m] == target {
			return m
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
	return -1
}
