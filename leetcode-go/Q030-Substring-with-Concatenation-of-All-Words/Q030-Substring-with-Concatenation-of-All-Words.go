package Q030_Substring_with_Concatenation_of_All_Words

func findSubstring(s string, words []string) []int {
	wordMap := map[string]int{}
	for _, w := range words {
		wordMap[w]++
	}

	wordLen := len(words[0])
	wordNum := len(words)

	ans := []int{}
	for i := 0; i < len(s)-wordLen*wordNum+1; i++ {
		seen := map[string]int{}
		j := 0
		for ; j < wordNum; j++ {
			word := s[i+j*wordLen : i+j*wordLen+wordLen]
			if _, exist := wordMap[word]; exist {
				seen[word]++
				if seen[word] > wordMap[word] {
					break
				}
			} else {
				break
			}
		}
		if j == wordNum {
			ans = append(ans, i)
		}
	}
	return ans
}
