package leetcode_go

import (
	"sort"
)

func threeSumClosest(nums []int, target int) int {
	if len(nums) == 3 {
		return nums[0] + nums[1] + nums[2]
	}
	sort.Ints(nums)
	res := nums[0] + nums[1] + nums[2]
	for i := 0; i < len(nums)-2; i++ {
		j := i + 1
		k := len(nums) - 1
		for j < k {
			sum := nums[i] + nums[j] + nums[k]
			if abs(sum-target) < abs(res-target) {
				res = sum
			}

			if sum == target {
				return res
			} else if sum > target {
				k--
			} else {
				j++
			}
		}
	}
	return res
}

func abs(a int) int {
	if a >= 0 {
		return a
	}
	return -a
}
