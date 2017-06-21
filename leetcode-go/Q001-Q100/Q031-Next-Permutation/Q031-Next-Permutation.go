package Q031_Next_Permutation

import (
	"sort"
)

func nextPermutation(nums []int) {
	if len(nums) < 2 {
		return
	}

	first := -1
	for i := len(nums) - 1; i >= 1; i-- {
		if nums[i-1] < nums[i] {
			first = i - 1
			break
		}
	}
	if first == -1 {
		sort.Ints(nums)
		return
	}

	second := -1
	for i := len(nums) - 1; i > first; i-- {
		if nums[i] > nums[first] {
			second = i
			break
		}
	}

	nums[first], nums[second] = nums[second], nums[first]
	sort.Ints(nums[first+1:])
}
