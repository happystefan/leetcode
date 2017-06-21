package Q039_Combination_Sum

import "sort"

func combinationSum(candidates []int, target int) [][]int {
	ans := [][]int{}
	sort.Ints(candidates)
	dfs(&ans, candidates, []int{}, target, 0)
	return ans
}

func dfs(ans *[][]int, candidates, combs []int, target int, begin int) {
	if target == 0 {
		*ans = append(*ans, combs)
		return
	}
	for i := begin; i < len(candidates) && target >= candidates[i]; i++ {
		ncombs := make([]int, len(combs))
		copy(ncombs, combs)

		dfs(ans, candidates, append(ncombs, candidates[i]), target-candidates[i], i)
	}
}
