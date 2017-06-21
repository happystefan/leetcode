package Q065_Valid_Number

import "strings"

func isNumber(s string) bool {
	s = strings.Trim(s, " ")
	var dotSeen, eSeen, digitSeen, digitAfterE bool
	for i, c := range s {
		if c >= '0' && c <= '9' {
			digitSeen = true
			if eSeen {
				digitAfterE = true
			}
		} else if c == '.' {
			if dotSeen || eSeen {
				return false
			}
			dotSeen = true
		} else if c == 'e' {
			if eSeen || !digitSeen {
				return false
			}
			eSeen = true
			digitAfterE = false
		} else if c == '-' || c == '+' {
			if i != 0 && s[i-1] != 'e' {
				return false
			}
		} else {
			return false
		}
	}
	return digitSeen && !eSeen || eSeen && digitAfterE
}
