package leetcode_go

import "sort"

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	if len(strs) == 1 {
		return strs[0]
	}
	sort.Strings(strs)
	stra, strb := strs[0], strs[len(strs)-1]
	res := []byte{}
	for i := range stra {
		if stra[i] != strb[i] {
			break
		}
		res = append(res, stra[i])
	}
	return string(res)
}
