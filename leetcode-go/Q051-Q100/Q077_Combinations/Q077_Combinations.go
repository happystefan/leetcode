package Q077_Combinations

func combine(n int, k int) [][]int {
	ans := [][]int{}
	if k > n {
		return ans
	}
	dfs(&ans, []int{}, 1, n, k)
	return ans
}

func dfs(ans *[][]int, comb []int, begin, n, k int) {
	if len(comb) == k {
		*ans = append(*ans, comb)
		return
	}
	for i := begin; i <= n; i++ {
		// NOTE: take care of the mem copy here
		ncomb := make([]int, len(comb))
		copy(ncomb, comb)
		dfs(ans, append(ncomb, i), i+1, n, k)
	}
}
