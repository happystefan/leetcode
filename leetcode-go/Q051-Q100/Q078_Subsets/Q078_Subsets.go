package main

func subsets(nums []int) [][]int {
	ans := [][]int{}
	ans = append(ans, []int{})
	for _, num := range nums {
		tmp := make([][]int, len(ans))
		// NOTE: take care of the copy here
		copy(tmp, ans)
		for j := 0; j < len(ans); j++ {
			com := make([]int, len(tmp[j]))
			// NOTE: take care of the copy here
			copy(com, tmp[j])
			tmp = append(tmp, append(com, num))
		}
		ans = tmp
	}

	return ans
}
