package leetcode_go

import (
	"sort"
)

func fourSum(nums []int, target int) [][]int {
	res := [][]int{}
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			l, r := j+1, len(nums)-1
			for l < r {
				a, b, c, d := nums[i], nums[j], nums[l], nums[r]
				if a+b+c+d < target {
					l++
				} else if a+b+c+d > target {
					r--
				} else {
					res = append(res, []int{a, b, c, d})
					for l < r && nums[l] == c {
						l++
					}
					for l < r && nums[r] == d {
						r--
					}
				}
			}
			for j+1 < len(nums) && nums[j+1] == nums[j] {
				j++
			}
		}
		for i+1 < len(nums) && nums[i+1] == nums[i] {
			i++
		}
	}
	return res
}
