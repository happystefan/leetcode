package Q040_Combination_Sum_II

import "sort"

func combinationSum2(candidates []int, target int) [][]int {
	sort.Ints(candidates)
	res := [][]int{}
	dfs(&res, candidates, []int{}, target, 0)
	return res
}

func dfs(res *[][]int, candidates []int, combs []int, target int, begin int) {
	if target == 0 {
		*res = append(*res, combs)
		return
	}
	for i := begin; i < len(candidates) && candidates[i] <= target; i++ {
		if i > begin && candidates[i] == candidates[i-1] {
			continue
		}
		dfs(res, candidates, append(combs, candidates[i]), target-candidates[i], i+1)
	}
}
