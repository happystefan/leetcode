package leetcode_go

func romanToInt(s string) int {
	num := make([]int, len(s))
	m := map[rune]int{
		'I': 1,
		'V': 5,
		'X': 10,
		'L': 50,
		'C': 100,
		'D': 500,
		'M': 1000,
	}
	for i, c := range s {
		num[i] = m[c]
	}

	res := 0
	for i := 0; i < len(s)-1; i++ {
		if num[i] < num[i+1] {
			res -= num[i]
		} else {
			res += num[i]
		}
	}
	return res + num[len(s)-1]
}
