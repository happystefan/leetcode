package Q022_Generate_Parentheses

// solution 1: recursive
func generateParenthesis(n int) []string {
	res := []string{}
	gao(&res, []byte(""), n, 0)
	return res
}

func gao(res *[]string, str []byte, m, n int) {
	if m == 0 && n == 0 {
		*res = append(*res, string(str))
		return
	}
	if m > 0 {
		gao(res, append(str, '('), m-1, n+1)
	}
	if n > 0 {
		gao(res, append(str, ')'), m, n-1)
	}
}

// solution 2: dfs
func generateParenthesis(n int) []string {
	res := []string{}
	dfs(&res, []byte(""), n, n)
	return res
}

func dfs(res *[]string, str []byte, m, n int) {
	if m > n {
		return
	}
	if m == 0 && n == 0 {
		*res = append(*res, string(str))
		return
	}
	if m > 0 {
		dfs(res, append(str, '('), m-1, n)
	}
	if n > 0 {
		dfs(res, append(str, ')'), m, n-1)
	}
}
