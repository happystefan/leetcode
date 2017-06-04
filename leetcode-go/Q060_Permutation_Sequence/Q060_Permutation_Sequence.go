package main //Q060_Permutation_Sequence

import (
	"fmt"
	"strings"
)

func getPermutation(n int, k int) string {
	nums := make([]int, n+1)
	for i := 0; i < n; i++ {
		nums[i] = i + 1
	}
	fact := make([]int, n)
	fact[0] = 1
	for i := 1; i < n; i++ {
		fact[i] = fact[i-1] * i
	}
	ans := []string{}
	k = k - 1
	for i := n; i > 0; i-- {
		idx := k / fact[i-1]
		ans = append(ans, fmt.Sprintf("%d", nums[idx]))
		k %= fact[i-1]
		nums = append(nums[:idx], nums[idx+1:]...)
	}
	return strings.Join(ans, "")
}
