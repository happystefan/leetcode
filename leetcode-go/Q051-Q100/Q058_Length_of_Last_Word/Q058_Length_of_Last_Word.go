package Q058_Length_of_Last_Word

import "strings"

func lengthOfLastWord(s string) int {
	s = strings.Trim(s, " ")
	ans := 0
	for _, c := range s {
		if c == ' ' {
			ans = 0
			continue
		}
		ans++
	}
	return ans
}
