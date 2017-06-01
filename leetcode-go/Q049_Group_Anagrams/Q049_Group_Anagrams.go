package Q049_Group_Anagrams

import (
	"sort"
	"strings"
)

func groupAnagrams(strs []string) [][]string {
	m := map[string][]string{}
	for _, str := range strs {
		s := strings.Split(str, "")
		sort.Strings(s)
		h := strings.Join(s, "")
		if m[h] == nil {
			m[h] = []string{}
		}
		m[h] = append(m[h], str)
	}
	ans := [][]string{}
	for _, v := range m {
		ans = append(ans, v)
	}
	return ans
}
