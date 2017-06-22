package Q090_Subsets_II

import "sort"

func subsetsWithDup(nums []int) [][]int {
	sort.Ints(nums)
	ans := [][]int{[]int{}}
	size := 0
	for i := 0; i < len(nums); i++ {
		start := 0
		if i >= 1 && nums[i] == nums[i-1] {
			start = size
		}
		size = len(ans)

		tmp := make([][]int, len(ans))
		copy(tmp, ans)

		for j := start; j < len(ans); j++ {
			com := make([]int, len(tmp[j]))
			copy(com, tmp[j])
			tmp = append(tmp, append(com, nums[i]))
		}
		ans = tmp
	}
	return ans
}
