package leetcode_go

// solution 1: brute force
func strStr(haystack string, needle string) int {
	for i := 0; i < len(haystack)-len(needle)+1; i++ {
		isSame := true
		for j := 0; j < len(needle); j++ {
			if haystack[i+j] != needle[j] {
				isSame = false
			}
		}
		if isSame {
			return i
		}
	}
	return -1
}

// TODO: solution 2: KMP
