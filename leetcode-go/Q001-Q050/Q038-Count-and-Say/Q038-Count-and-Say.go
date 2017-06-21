package Q038_Count_and_Say

import "fmt"

func countAndSay(n int) string {
	str := "1"
	if n == 1 {
		return str
	}
	for i := 1; i < n; i++ {
		tmp := []byte("")
		num := str[0]
		cnt := 1
		for j := 1; j < len(str); j++ {
			if str[j] == num {
				cnt++
			} else {
				tmp = append(tmp, []byte(fmt.Sprintf("%d%c", cnt, num))...)
				num = str[j]
				cnt = 1
			}
		}
		tmp = append(tmp, []byte(fmt.Sprintf("%d%c", cnt, num))...)
		str = string(tmp)
	}
	return str
}
