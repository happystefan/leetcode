package Q047_Permutations_II

import "sort"

func permuteUnique(nums []int) [][]int {
	sort.Ints(nums)
	visit := make([]bool, len(nums))
	ans := [][]int{}
	gao(&ans, []int{}, nums, visit)
	return ans
}

func gao(ans *[][]int, perms []int, nums []int, visit []bool) {
	if len(perms) == len(nums) {
		*ans = append(*ans, perms)
		return
	}

	for i := 0; i < len(nums); i++ {
		if visit[i] {
			continue
		}
		if i > 0 && nums[i-1] == nums[i] && !visit[i-1] {
			continue
		}
		visit[i] = true

		// NOTE: take care of the memcopy here
		nperms := make([]int, len(perms))
		copy(nperms, perms)

		gao(ans, append(nperms, nums[i]), nums, visit)
		visit[i] = false
	}
}
