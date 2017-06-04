package Q053_Maximum_Subarray_B

func maxSubArray(nums []int) int {
	ans := nums[0]
	sum := nums[0]
	for i := 1; i < len(nums); i++ {
		sum = max(nums[i], sum+nums[i])
		ans = max(ans, sum)
	}
	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
