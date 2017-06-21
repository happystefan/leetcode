package Q020_Valid_Parentheses

func isValid(s string) bool {
	stack := []byte{}
	for i := range s {
		if len(stack) > 0 && isParentheseMatch(stack[len(stack)-1], s[i]) {
			stack = stack[0 : len(stack)-1]
		} else {
			stack = append(stack, s[i])
		}
	}
	return len(stack) == 0
}

func isParentheseMatch(a, b byte) bool {
	if a == '(' && b == ')' || a == '{' && b == '}' || a == '[' && b == ']' {
		return true
	}
	return false
}
