package Q008_String_to_Integer_atoi_

import (
	"math"
	"strings"
)

func myAtoi(str string) int {
	sign, num := int64(1), int64(0)
	str = strings.Trim(str, " ")
	if len(str) == 0 {
		return 0
	}
	i := 0
	if str[0] == '-' || str[0] == '+' {
		if str[0] == '-' {
			sign = -1
		}
		if str[0] == '+' {
			sign = 1
		}
		i++
	}

	for ; i < len(str); i++ {
		if '0' <= str[i] && str[i] <= '9' {
			num = num*10 + int64(str[i]-'0')
			if sign*num > math.MaxInt32 {
				return math.MaxInt32
			}
			if sign*num < math.MinInt32 {
				return math.MinInt32
			}
		} else { // if contains any invalid char, return
			return int(sign * num)
		}
	}
	return int(sign * num)
}
