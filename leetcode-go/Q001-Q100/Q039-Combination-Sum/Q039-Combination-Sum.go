package main //Q039_Combination_Sum
import (
	//	"fmt"
	//	"sort"
	//	"reflect"
	"fmt"
	"sort"
)

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
		dfs(ans, candidates, append(combs, candidates[i]), target-candidates[i], i)
	}
}

func main() {
	//combinationSum([]int{33,28,25,45,26,27,47,29,32,21,37,35,48,49,40,39,41,46,20,24,30,36,38,44,23,34}, 51)
	fmt.Println(combinationSum([]int{1, 2}, 4))
}
