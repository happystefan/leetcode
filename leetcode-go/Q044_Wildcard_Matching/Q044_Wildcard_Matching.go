package Q044_Wildcard_Matching

func isMatch(s string, p string) bool {
	dp := make([][]bool, len(p)+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]bool, len(s)+1)
	}
	dp[len(p)][len(s)] = true

	for i := len(p) - 1; i >= 0; i-- {
		if p[i] != '*' {
			break
		}
		dp[i][len(s)] = true
	}

	for i := len(p) - 1; i >= 0; i-- {
		for j := len(s) - 1; j >= 0; j-- {
			if p[i] == s[j] || p[i] == '?' {
				dp[i][j] = dp[i+1][j+1]
			} else if p[i] == '*' {
				dp[i][j] = dp[i+1][j] || dp[i][j+1]
			} else {
				dp[i][j] = false
			}
		}
	}
	return dp[0][0]
}
