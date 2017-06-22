package Q091_Decode_Ways

import "strconv"

func numDecodings(s string) int {
	if len(s) == 0 {
		return 0
	}
	dp := make([]int, len(s)+1)
	dp[0] = 1
	if s[0] != 0 {
		dp[1] = 1
	}
	for i := 2; i <= len(s); i++ {
		n1, _ := strconv.Atoi(s[i-1 : i])
		n2, _ := strconv.Atoi(s[i-2 : i])

		if n1 >= 1 && n1 <= 9 {
			dp[i] += dp[i-1]
		}
		if n2 >= 10 && n2 <= 26 {
			dp[i] += dp[i-2]
		}
	}
	return dp[len(s)]
}
