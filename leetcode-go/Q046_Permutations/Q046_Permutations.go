package Q046_Permutations

func permute(nums []int) [][]int {
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
		visit[i] = true
		gao(ans, append(perms, nums[i]), nums, visit)
		visit[i] = false
	}
}
