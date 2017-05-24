package leetcode_go

/*
// solution 1: dp
func isMatch(s string, p string) bool {
	m, n := len(s), len(p)
	// NOTE: take care of the initialization here
	dp := make([][]bool, m+1)
	for i := 0; i < m+1; i++ {
		dp[i] = make([]bool, n+1)
	}

	dp[0][0] = true
	for i := 0; i < n; i++ {
		if p[i] == '*' && dp[0][i-1] {
			dp[0][i+1] = true
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if s[i] == p[j] {
				dp[i+1][j+1] = dp[i][j]
			}
			if p[j] == '.' {
				dp[i+1][j+1] = dp[i][j]
			}
			if p[j] == '*' {
				if p[j-1] != s[i] && p[j-1] != '.' {
					dp[i+1][j+1] = dp[i+1][j-1]
				} else {
					dp[i+1][j+1] = dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1]
				}
			}
		}
	}
	return dp[m][n]
}
*/

// solution 2: recursive
func isMatch(s string, p string) bool {
	m, n := len(s), len(p)
	if n == 0 {
		return m == 0
	}

	if n == 1 {
		if m == 0 {
			return false
		}
		if p[0] == '*' {
			return false
		}
		if m == 1 && (s[0] == p[0] || p[0] == '.') {
			return true
		} else {
			return false
		}
	}

	// len(p) >= 2
	if p[1] == '*' {
		// "x*" matches empty string or at least one character: x* -> xx*
		return isMatch(s, p[2:n]) || (m != 0 && (s[0] == p[0] || p[0] == '.') && isMatch(s[1:m], p))

	} else { //p[1] != "*"
		/*
			if m == 0 {
				return false
			}
			if p[0] == '.' {
				return isMatch(s[1:m], p[1:n])
			}
			if s[0] == p[0] { // p[0] != '.'
				return isMatch(s[1:m], p[1:n])
			} else {
				return false
			}
		*/
		return m != 0 && (s[0] == p[0] || p[0] == '.') && isMatch(s[1:m], p[1:n])
	}
	return false
}
