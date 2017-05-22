package leetcode_go

// solution 1, the iterative approach
/*
func letterCombinations(digits string) []string {
	m := []string{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}
	if len(digits) == 0 {
		return []string{}
	}
	res := []string{""}
	for _, d := range digits {
		tmp := []string{}
		for i := range m[d-'0'] {
			for j := range res {
				str := append([]byte(res[j]), m[d-'0'][i])
				tmp = append(tmp, string(str))
			}
		}
		res = tmp
	}
	return res
}
*/
// solution 2, the recursive approach

func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	res := []string{}
	gao([]byte(""), digits, &res)
	return res
}

func gao(prefix []byte, digits string, res *[]string) {
	m := []string{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}
	if len(digits) == 0 {
		*res = append(*res, string(prefix))
		return
	}
	letters := m[digits[0]-'0']
	for i := range letters {
		gao(append([]byte(prefix), letters[i]), digits[1:], res)
	}
}
