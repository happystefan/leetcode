package Q034_Search_for_a_Range

func searchRange(nums []int, target int) []int {
	first := bsearchFirst(nums, target)
	last := bsearchLast(nums, target)
	return []int{first, last}
}

func bsearchFirst(nums []int, target int) int {
	idx := -1
	l, h := 0, len(nums)-1
	for l <= h {
		m := (l + h) / 2
		if nums[m] >= target {
			h = m - 1
		} else {
			l = m + 1
		}
		if nums[m] == target {
			idx = m
		}
	}

	return idx
}

func bsearchLast(nums []int, target int) int {
	idx := -1
	l, h := 0, len(nums)-1
	for l <= h {
		m := (l + h) / 2
		if nums[m] <= target {
			l = m + 1
		} else {
			h = m - 1
		}
		if nums[m] == target {
			idx = m
		}
	}

	return idx
}
