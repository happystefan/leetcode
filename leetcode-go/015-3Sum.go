package leetcode_go

import "sort"

func threeSum(nums []int) [][]int {
	res := [][]int{}
	sort.Ints(nums)
	for i:=0; i<len(nums); i++ {
		l, r := i+1, len(nums)-1
		for l < r {
			a, b, c := nums[i], nums[l], nums[r]
			if b+c < -a {
				l++
			} else if b+c > -a {
				r--
			} else {
				res = append(res, []int{a, b, c})
				// Processing duplicates of Number b
				// Rolling the front pointer to the next different number forwards
				for l < r && nums[l] == b {
					l++
				}
				// Processing duplicates of Number c
				// Rolling the back pointer to the next different number backwards
				for l < r && nums[r] == c {
					r--
				}
			}
		}
		// Processing duplicates of Number a
		for i+1<len(nums) && nums[i+1]==nums[i] {
			i++
		}
	}
	return res
}
