package Q096_Unique_Binary_Search_Trees

func numTrees(n int) int {
	dp := make([]int, n+3)
	dp[0] = 1
	dp[1] = 1
	dp[2] = 2
	for i := 3; i <= n; i++ {
		for j := 1; j <= i; j++ {
			dp[i] += dp[j-1] * dp[i-j]
		}
	}
	return dp[n]
}
