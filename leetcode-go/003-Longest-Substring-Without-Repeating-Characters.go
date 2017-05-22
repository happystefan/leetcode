package leetcode_go

func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 {
		return 0
	}

	m := map[byte]int{}
	lenz := 0

	for l, r := 0, 0; r < len(s); r++ {
		if _, exist := m[s[r]]; exist {
			l = max(l, m[s[r]]+1)
			//l =  m[s[r]]+1
		}
		m[s[r]] = r
		lenz = max(lenz, r-l+1)
	}

	return lenz
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
