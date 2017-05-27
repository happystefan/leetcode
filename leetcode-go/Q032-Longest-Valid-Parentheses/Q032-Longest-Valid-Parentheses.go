package Q032_Longest_Valid_Parentheses

func longestValidParentheses(s string) int {
	stack := []int{}
	for i := 0; i < len(s); i++ {
		if len(stack) != 0 && s[stack[len(stack)-1]] == '(' && s[i] == ')' {
			stack = stack[0 : len(stack)-1]
		} else {
			stack = append(stack, i)
		}
	}

	if len(stack) == 0 {
		return len(s)
	}
	if stack[0] != 0 {
		stack = append([]int{-1}, stack...)
	}
	if stack[len(stack)-1] != len(s)-1 {
		stack = append(stack, len(s))
	}

	ans := 0
	for i := 0; i < len(stack)-1; i++ {
		if stack[i+1]-stack[i]-1 > ans {
			ans = stack[i+1] - stack[i] - 1
		}
	}
	return ans
}
